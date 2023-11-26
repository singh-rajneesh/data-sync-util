package com.project.datasyncservice.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class AdvisorConstants {
    public static final String COUNTRY_CODE_KEY = "country_code";
    public static final String COUNTRY_DESC_KEY = "country_description";
    public static final String INDIA_COUNTRY_CODE = "IN";

    public static final Integer LEVEL_0 = 0;

    public static final String LEVEL_DESC_TEMPLATE = "location_hierarchy_level_%d_desc";
    public static final String LEVEL_CODE_TEMPLATE = "location_hierarchy_level_%d_code";
    public static final String LEVEL_NAME_TEMPLATE = "location_hierarchy_level_%d_name";

    public static final String SUPPORTED_GEO_LOCATION_TYPE = "Point";

    public static final String DESTINATION_KEY = "destinations";
    public static final String ORIGIN_KEY = "origins";
    public static final String ADDRESS_KEY = "address";
    public static final String LATLNG = "latlng";
    public static final String FIELDS = "fields";
    public static final String INPUT = "input";
    public static final String INPUT_TYPE = "inputtype";
    public static final String TEXT_QUERY = "textquery";
    public static final String S3_DATA_SYNC_DATA_CONTEXT_REGEX = "/([^/-]+)-";
    public static final String ADMIN_LEVEL_DATA_REGEX = "^administrative_area_level_\\d+$";

    public static final String ADVISOR = "ADVISOR";

    public static final String AMS_BEARER_TOKEN = "ams_bearer_token";
    public static final String FORMATTED_ADDRESS = "formatted_address";
    public static final String GEOMETRY = "geometry";
    public static final String PLACE_ID = "place_id";
    public static final String LOCALITY = "locality";
    public static final String SUB_LOCALITY = "sublocality";

    public static final String ZERO_RESULTS = "ZERO_RESULTS";
    public static final String ACTIVE = "ACTIVE";
    public static final String CROP_NAME = "cropName";
    public static final String CROP_DISEASE_NAME = "cropDiseaseName";
    public static final String CROP_DISEASE_DESC = "cropDiseaseDesc";
    public static final String PRODUCT_NAMES = "productNames";
    public static final Long PRE_ORDER_SUCCESS_STATUS = 2000L;

    public static final String COUNTRY_CODE = "+91";

    public static final String ADVISOR_USER_DATA_UPDATE_EVENT = "advisor_user_data_update";
    public static final String LOCATION_DETAIL_LEVEL_VILLAGE = "VILLAGE";
    public static final String LOCATION_DETAIL_LEVEL_DISTRICT = "DISTRICT";
    public static final String LOCATION_DETAIL_LEVEL_TALUKA = "TALUKA";
    public static final String DIRECT_PURCHASE = "ACF";

    public static final String REDIS_KEY_ADVISOR_DETAIL_APAC_CODE = "ADVISOR_DETAIL_APAC_CODE";
    public static final String REDIS_KEY_ADVISOR_DETAIL_ID = "ADVISOR_DETAIL_ID";
    public static final String REDIS_KEY_CONTENT_LANGUAGE_ID = "CONTENT_LANGUAGE_ID";
}