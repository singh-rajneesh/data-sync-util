package com.project.datasyncservice.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ExceptionConstants {

    public static final String GEO_LOCATION_NOT_FOUND = "GEO_LOCATION_NOT_FOUND";

    public static final String USER_SERVICE_GET_PRE_SIGNED_URL_API_SERVER_ERROR = "USER_SERVICE_GET_PRE_SIGNED_URL_API_SERVER_ERROR";

    public static final String USER_SERVICE_GET_PRE_SIGNED_URL_API_NOT_FOUND_ERROR = "USER_SERVICE_GET_PRE_SIGNED_URL_API_NOT_FOUND_ERROR";

    public static final String USER_SERVICE_GET_SHORT_DETAILS_API_SERVER_ERROR = "USER_SERVICE_GET_SHORT_DETAILS_API_SERVER_ERROR";

    public static final String USER_SERVICE_GET_SHORT_DETAILS_API_NOT_FOUND_ERROR = "USER_SERVICE_GET_SHORT_DETAILS_API_NOT_FOUND_ERROR";
    public static final String USER_SERVICE_GET_USER_DETAILS_API_NOT_FOUND_ERROR = "USER_SERVICE_GET_USER_DETAILS_API_NOT_FOUND_ERROR";

    public static final String DATA_SYNC_FILE_FORMAT_ERROR = "INVALID FILE FORMAT IN S3 FOR FILE";


    public static final String USER_GET_NOTIFICATION_DETAIL_API_NOT_FOUND_ERROR = "USER_GET_NOTIFICATION_DETAIL_API_NOT_FOUND_ERROR";
    public static final String USER_GET_NOTIFICATION_DETAIL_API_SERVER_ERROR = "USER_GET_NOTIFICATION_DETAIL_API_SERVER_ERROR";
    public static final String WHATSAPP_SERVICE_API_SERVER_ERROR = "WHATSAPP_SERVICE_API_SERVER_ERROR";

    public static final String ADVISOR_PRE_ORDER_API_SERVER_ERROR = "ADVISOR_PRE_ORDER_API_SERVER_ERROR";
    public static final String ADVISOR_PURCHASE_FULFILLMENT_API_SERVER_ERROR = "ADVISOR_PURCHASE_FULFILLMENT_API_SERVER_ERROR";

    public static final String ADVISOR_PRE_ORDER_API_NOT_FOUND_ERROR = "ADVISOR_PRE_ORDER_API_NOT_FOUND_ERROR";
    public static final String ADVISOR_PURCHASE_FULFILLMENT_API_NOT_FOUND_ERROR = "ADVISOR_PURCHASE_FULFILLMENT_API_NOT_FOUND_ERROR";

    public static final String ADVISOR_DETAIL_BY_VILLAGE_4xx_ERROR = "ADVISOR_DETAIL_BY_VILLAGE_4xx_ERROR";
    public static final String ADVISOR_DETAIL_BY_VILLAGE_5xx_ERROR = "ADVISOR_DETAIL_BY_VILLAGE_5xx_ERROR";

    public static final String ADVISOR_DETAIL_4xx_ERROR = "ADVISOR_DETAIL_4xx_ERROR";
    public static final String ADVISOR_DETAIL_5xx_ERROR = "ADVISOR_DETAIL_5xx_ERROR";

    public static final String ORDER_DETAIL_4xx_ERROR = "ORDER_DETAIL_4xx_ERROR";
    public static final String ORDER_DETAIL_5xx_ERROR = "ORDER_DETAIL_5xx_ERROR";

    public static final String TRANSLITERATION_4xx_ERROR = "TRANSLITERATION_4xx_ERROR";
    public static final String TRANSLITERATION_5xx_ERROR = "TRANSLITERATION_5xx_ERROR";

    public static final String AZURE_AUTH_API_SERVER_ERROR = "AZURE_AUTH_API_SERVER_ERROR";

    public static final String AZURE_AUTH_NOT_FOUND_ERROR = "AZURE_AUTH_NOT_FOUND_ERROR";

    public static final String ORDER_INTENT_ALREADY_PRESENT = "ORDER_INTENT_ALREADY_PRESENT";

    public static final String ORDER_INTENT_NOT_AVAILABLE_FOR_ORDER_ID = "ORDER_INTENT_NOT_AVAILABLE_FOR_ORDER_ID";

    public static final String ANOTHER_ORDER_FOUND_FOR_PROVIDED_INTENT = "ANOTHER_ORDER_FOUND_FOR_PROVIDED_INTENT";

    public static final String NEARBY_ADVISORS_NOT_AVAILABLE = "NO_NEARBY_ADVISORS_AVAILABLE";
    public static final String NO_ADVISOR_AVAILABLE_FOR_VILLAGE = "NO_ADVISOR_AVAILABLE_FOR_VILLAGE";
    public static final String NO_ADVISOR_CONTACTED = "NO_ADVISOR_CONTACTED";
    public static final String ORDER_INTENT_NOT_VALID_FOR_REASSIGN = "ORDER_INTENT_NOT_VALID_FOR_REASSIGN";
    public static final String ADVISOR_NOT_VALID_FOR_REASSIGN = "ADVISOR_ID_NOT_VALID_FOR_REASSIGN";
    public static final String EXCEPTION_PROCESSING_S3_DATA = "ERROR_WHILE_PROCESSING_S3_DATA";
    public static final String ORDER_NOT_FOUND = "NO_ORDER_FOUND";
    public static final String ORDER_PROCESSING_EXCEPTION = "Exception in Order Processing Listener";
    public static final String PURCHASE_PROCESSING_EXCEPTION = "Exception in Purchase Fulfillment Listener";
    public static final String ORDER_INTENT_NOTIFICATION_STATUS_NOT_VALID = "Order Intent Status is not valid for whatsapp notification";
    public static final String ORDER_NOTIFICATION_STATUS_NOT_VALID = "Order Status is not valid for whatsapp notification";

    public static final String AGRONOMY_GET_EN_NAME_CROP_NOT_FOUND_ERROR = "EN crop name in agronomy service is not found";
    public static final String USER_NAME_NOT_VALID = "USER_NAME_NOT_VALID";
    public static final String PRODUCT_DETAILS_NOT_FOUND = "Product details missing for given productId";

}