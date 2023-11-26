package com.project.datasyncservice.mapper;

import com.project.datasyncservice.dto.FaqDTO;
import org.mapstruct.*;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, config = AuditMapper.class,
        builder = @Builder(disableBuilder = true))
public interface StaticContentMapper {

    @InheritConfiguration
    @Mapping(target = "title", source = "question")
    FaqDTO map(StaticContent source);

    @InheritConfiguration
    @Mapping(target = "question", source = "title")
    StaticContent map(FaqDTO source);

    default List<FaqDTO> map(List<StaticContent> list) {
        return list.stream().map(this::map).collect(Collectors.toList());
    }
}
