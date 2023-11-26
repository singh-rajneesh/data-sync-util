package com.project.datasyncservice.entity;

import com.project.datasyncservice.model.UserGeoLocation;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user_detail")
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = false)
public class UserDetail extends BaseEntity {

    @Id
    private String id;

    private String farmerName;

    @Indexed(unique = true)
    private String mobileNumber;

    private UserGeoLocation location;

    private Integer preferredLanguageId;

}
