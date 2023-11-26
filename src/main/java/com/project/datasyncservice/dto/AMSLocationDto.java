package com.project.datasyncservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode
@ToString
@RequiredArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AMSLocationDto {

    @JsonProperty("country_code")
    private String countryCode;

    @JsonProperty("country_description")
    private String countryDesc;

    @JsonProperty("location_hierarchy_level_1_name")
    private String locationHierarchyLevel1Name;
    @JsonProperty("location_hierarchy_level_1_code")
    private String locationHierarchyLevel1Code;
    @JsonProperty("location_hierarchy_level_1_desc")
    private String locationHierarchyLevel1Desc;

    @JsonProperty("location_hierarchy_level_2_name")
    private String locationHierarchyLevel2Name;
    @JsonProperty("location_hierarchy_level_2_code")
    private String locationHierarchyLevel2Code;
    @JsonProperty("location_hierarchy_level_2_desc")
    private String locationHierarchyLevel2Desc;


    @JsonProperty("location_hierarchy_level_3_name")
    private String locationHierarchyLevel3Name;
    @JsonProperty("location_hierarchy_level_3_code")
    private String locationHierarchyLevel3Code;
    @JsonProperty("location_hierarchy_level_3_desc")
    private String locationHierarchyLevel3Desc;


    @JsonProperty("location_hierarchy_level_4_name")
    private String locationHierarchyLevel4Name;
    @JsonProperty("location_hierarchy_level_4_code")
    private String locationHierarchyLevel4Code;
    @JsonProperty("location_hierarchy_level_4_desc")
    private String locationHierarchyLevel4Desc;

    @JsonProperty("location_hierarchy_level_5_name")
    private String locationHierarchyLevel5Name;
    @JsonProperty("location_hierarchy_level_5_code")
    private String locationHierarchyLevel5Code;
    @JsonProperty("location_hierarchy_level_5_desc")
    private String locationHierarchyLevel5Desc;

}
