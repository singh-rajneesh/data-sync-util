package com.project.datasyncservice.service.impl;

import com.amazonaws.services.s3.model.S3Object;
import com.climate.event.gateway.QueueGateway;
import com.project.datasyncservice.bo.AMSUserDetailBO;
import com.project.datasyncservice.config.rabbit.OrderIntentQueueNames;
import com.project.datasyncservice.constants.AMSLanguageMappingEnum;
import com.project.datasyncservice.constants.ExceptionConstants;
import com.project.datasyncservice.constants.S3DataTypesEnum;
import com.project.datasyncservice.dto.S3DataDto;
import com.project.datasyncservice.dto.UserDetailDTO;
import com.project.datasyncservice.exception.DataSyncFileFormatException;
import com.project.datasyncservice.mapper.UserDetailMapper;
import com.project.datasyncservice.service.DataProcessingService;
import com.project.datasyncservice.service.UserDetailsService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service(value = "USER_PROCESSOR")
@RequiredArgsConstructor
public class FarmerDataProcessingServiceImpl implements DataProcessingService {

    private final ObjectMapper objectMapper;

    private final QueueGateway queueGateway;

    private final UserDetailsService userDetailsService;
    private UserDetailMapper userDetailMapper;

    @Override
    public void processData(S3Object object) {
        try {
            List<AMSUserDetailBO> amsUserDetails = objectMapper.readValue(object.getObjectContent(),
                    new TypeReference<List<AMSUserDetailBO>>() {
                    });
            List<UserDetailDTO> userDetails =
                    amsUserDetails.stream().map(amsUserDetailBO -> {
                                Integer preferredLanguageId = AMSLanguageMappingEnum.getLanguageId(amsUserDetailBO.getPreferredLanguage());
                                UserDetailDTO userDetailDTO = userDetailMapper.map(amsUserDetailBO);
                                userDetailDTO.setPreferredLanguageId(preferredLanguageId);
                                return userDetailDTO;
                            })
                            .collect(Collectors.toList());
            userDetails.forEach(userDetail -> queueGateway.pushEventToQueue(prepareS3Data(userDetail, object.getKey(), S3DataTypesEnum.FARMER_DATA.getDataContext()),
                    OrderIntentQueueNames.S3_DATA_PROCESSING_QUEUE));

        } catch (Exception e) {
            throw new DataSyncFileFormatException(ExceptionConstants.DATA_SYNC_FILE_FORMAT_ERROR);

        }
    }

    @Override
    public void processData(S3DataDto s3DataDto) {
        log.info("FarmerDataProcessingServiceImpl.processData():: processing s3DataDto={}", s3DataDto);
        UserDetailDTO userDetailDTO = objectMapper.convertValue(s3DataDto.getData(), UserDetailDTO.class);
        UserDetailDTO savedUserData = userDetailsService.saveUserData(userDetailDTO);
        log.info("FarmerDataProcessingServiceImpl.processData():: saved user data={}", savedUserData);
    }

}

