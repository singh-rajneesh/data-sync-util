package com.project.datasyncservice.mapper;

import com.project.datasyncservice.dto.TranslationContentDTO;
import org.mapstruct.Builder;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, config = AuditMapper.class,
        builder = @Builder(disableBuilder = true))
public interface TranslationContentMapper {

    @InheritConfiguration
    TranslationContent map(TranslationContentDTO source);

    @InheritConfiguration
    TranslationContentDTO map(TranslationContent source);

    default List<TranslationContent> map(List<TranslationContentDTO> list) {
        return list.stream().map(this::map).collect(Collectors.toList());
    }
}
