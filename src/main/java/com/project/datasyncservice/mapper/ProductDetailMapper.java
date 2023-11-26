package com.project.datasyncservice.mapper;

import com.project.datasyncservice.dto.ProductDetailDTO;
import com.project.datasyncservice.entity.ProductDetail;
import org.mapstruct.Builder;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, config = AuditMapper.class,
        builder = @Builder(disableBuilder = true))
public interface ProductDetailMapper {

    @InheritConfiguration
    ProductDetailDTO map(ProductDetail source);

    @InheritConfiguration
    ProductDetail map(ProductDetailDTO source);

    default List<ProductDetail> map(List<ProductDetailDTO> list) {
        return list.stream().map(this::map).collect(Collectors.toList());
    }
}
