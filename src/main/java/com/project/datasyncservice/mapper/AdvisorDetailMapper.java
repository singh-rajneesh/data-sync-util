package com.project.datasyncservice.mapper;

import com.project.datasyncservice.bo.AMSUserDetailBO;
import com.project.datasyncservice.constants.AdvisorConstants;
import com.project.datasyncservice.dto.AdvisorDetailDTO;
import com.project.datasyncservice.model.LocationGeoJson;
import com.project.datasyncservice.model.UserGeoLocation;
import org.mapstruct.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, config = AuditMapper.class,
        builder = @Builder(disableBuilder = true))
public interface AdvisorDetailMapper {
    @InheritConfiguration
    AdvisorDetailDTO map(AdvisorDetail source);

    @Mapping(target = "loc", expression = "java(getGeoJson(source.getLocation()))")
    @InheritConfiguration
    AdvisorDetail map(AdvisorDetailDTO source);

    @Mapping(target = "advisorUserId", source = "customerId")
    @Mapping(target = "phoneNumber", source = "phoneNumber")
    @Mapping(target = "name", source = "contactPerson")
    @Mapping(target = "status", source = "accountStatus")
    @Mapping(target = "locationHierarchy", source = "geo")
    AdvisorDetailDTO map(AMSUserDetailBO source);

    default List<AdvisorDetailDTO> map(List<AdvisorDetail> list) {
        return list.stream().map(this::map).collect(Collectors.toList());
    }

    default LocationGeoJson getGeoJson(UserGeoLocation source) {
        List<Double> coordinates = Arrays.asList(Double.valueOf(source.getLongitude()), Double.valueOf(source.getLatitude()));
        return LocationGeoJson.builder()
                .coordinates(coordinates)
                .type(AdvisorConstants.SUPPORTED_GEO_LOCATION_TYPE)
                .build();
    }

}