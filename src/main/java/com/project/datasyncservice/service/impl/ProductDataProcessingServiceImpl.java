package com.project.datasyncservice.service.impl;

import com.amazonaws.services.s3.model.S3Object;
import com.climate.event.gateway.QueueGateway;
import com.project.datasyncservice.config.rabbit.OrderIntentQueueNames;
import com.project.datasyncservice.constants.ExceptionConstants;
import com.project.datasyncservice.constants.S3DataTypesEnum;
import com.project.datasyncservice.dto.ProductDetailDTO;
import com.project.datasyncservice.dto.S3DataDto;
import com.project.datasyncservice.entity.ProductDetail;
import com.project.datasyncservice.exception.S3DataProcessingException;
import com.project.datasyncservice.mapper.ProductDetailMapper;
import com.project.datasyncservice.repository.ProductDetailRepository;
import com.project.datasyncservice.service.DataProcessingService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service(value = "PRODUCT_PROCESSOR")
@RequiredArgsConstructor
public class ProductDataProcessingServiceImpl implements DataProcessingService {

    private final ObjectMapper objectMapper;

    private final ProductDetailRepository productDetailRepository;

    private final ProductDetailMapper productDetailMapper;
    private final QueueGateway queueGateway;

    @Override
    public void processData(S3Object object) {
        try {
            List<ProductDetailDTO> productDetails = objectMapper.readValue(object.getObjectContent(),
                    new TypeReference<List<ProductDetailDTO>>() {
                    });

            productDetails.forEach(productDetail -> queueGateway.pushEventToQueue(prepareS3Data(productDetail, object.getKey(), S3DataTypesEnum.PRODUCT_DATA.getDataContext()),
                    OrderIntentQueueNames.S3_DATA_PROCESSING_QUEUE));

        } catch (Exception e) {
            throw new S3DataProcessingException(ExceptionConstants.DATA_SYNC_FILE_FORMAT_ERROR);
        }
    }

    @Override
    public void processData(S3DataDto s3DataDto) {
        log.info("OrderDataProcessingServiceImpl.processData():: processing s3DataDto={}", s3DataDto);
        ProductDetailDTO productDetailDto = objectMapper.convertValue(s3DataDto.getData(), ProductDetailDTO.class);
        ProductDetailDTO savedProductData = saveProductData(productDetailDto);
        log.info("OrderDataProcessingServiceImpl.processData():: saved product data={}", savedProductData);
    }

    private ProductDetailDTO saveProductData(ProductDetailDTO productDetailDto) {
        try {
            Optional<ProductDetail> existingProduct = productDetailRepository.findByProductId(Long.valueOf(productDetailDto.getProductId()));
            if (existingProduct.isPresent()) {
                String existingProductId = existingProduct.get().getId();
                ProductDetail productToUpdate = productDetailMapper.map(productDetailDto);
                productToUpdate.setId(existingProductId);
                return productDetailMapper.map(productDetailRepository.save(productToUpdate));
            }
            ProductDetail savedProduct = productDetailRepository.save(productDetailMapper.map(productDetailDto));
            return productDetailMapper.map(savedProduct);
        } catch (Exception e) {
            log.error("ProductDataProcessingServiceImpl.saveProductData():: error while saving productId={} with " +
                    "exception= ", productDetailDto.getProductId(), e);
            throw new S3DataProcessingException(ExceptionConstants.EXCEPTION_PROCESSING_S3_DATA);
        }
    }
}