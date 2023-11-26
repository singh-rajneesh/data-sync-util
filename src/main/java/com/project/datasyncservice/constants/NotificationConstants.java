package com.project.datasyncservice.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class NotificationConstants {

    //Attributes
    public static final String ORDER_ID = "orderId";
    public static final String CROP_NAME = "cropName";
    public static final String CROP_ISSUE = "cropIssue";
    public static final String RECOMMENDED_PRODUCT = "recommendedProduct";
    public static final String FARMER_PHONE_NUMBER = "farmerPhoneNumber";
    public static final String ORDER_STATUS = "orderStatus";
    public static final String ORDER_INTENT_STATUS = "orderIntentStatus";
    public static final String ADVISOR_NAME = "advisorName";

    //WhatsappEvents
    public static final String PRE_ORDER_INTENT_ADVISOR = "ams_pre_order_intent";
    public static final String PRE_ORDER_INTENT_FARMER = "ams_pre_order_notify";
    public static final String ORD_REASSIGN = "ams_ord_reassign";
    public static final String ORD_CREATED = "ams_ord_created";
    public static final String ORD_CREATED_NONFR = "ams_ord_created_nonfr";
    public static final String ORD_MODIFY = "ams_ord_modify";
    public static final String ORD_FULFILLED = "ams_ord_fulfilled";
    public static final String ORD_CANCELLED = "ams_ord_cancelled";
    public static final String ORD_RETAILER_DECLINE = "ams_ord_retailer_decline";
    public static final String ORD_EXPIRED = "ams_ord_expired";
    public static final String ORD_PARTIALLY_FULFILLED = "ams_ord_partially_fulfilled";

    //Push Notifications
    public static final String ORDER_STATUS_PUSH_NOTIFICATION = "ORDER_STATUS_NOTIFICATION";
    public static final String PRE_ORDER_REASSIGN_PUSH_NOTIFICATION = "PRE_ORDER_REASSIGN_NOTIFICATION";

    public static final String CROP_NAME_TAG = "<crop_name>";
    public static final String CROP_ISSUE_TAG = "<crop_issue>";
    public static final String ADVISOR_NAME_TAG = "<Advisor Name>";
    public static final String ORDER_STATUS_TAG = "<order_status>";
    public static final String ORDER_ID_TAG = "<1234>";
    public static final String DUMMY_IMAGE = "DUMMY_IMAGE";
}
