package com.project.datasyncservice.mapper;

import com.project.datasyncservice.bo.AMSUserDetailBO;
import com.project.datasyncservice.dto.UserDetailDTO;
import com.project.datasyncservice.entity.UserDetail;
import org.mapstruct.*;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, config = AuditMapper.class,
        builder = @Builder(disableBuilder = true))
public interface UserDetailMapper {
    @InheritConfiguration
    @Mapping(target = "farmerUserId", source = "id")
    UserDetailDTO map(UserDetail source);

    @InheritConfiguration
    @Mapping(target = "id", source = "farmerUserId")
    UserDetail map(UserDetailDTO source);

    @Mapping(target = "farmerUserId", source = "customerId")
    @Mapping(target = "mobileNumber", source = "phoneNumber")
    @Mapping(target = "farmerName", source = "contactPerson")
    @Mapping(target = "status", source = "accountStatus")
    @Mapping(target = "locationHierarchy", source = "geo")
    UserDetailDTO map(AMSUserDetailBO source);

    default List<UserDetail> map(List<UserDetailDTO> list) {
        return list.stream().map(this::map).collect(Collectors.toList());
    }
}
