package com.project.datasyncservice.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class NotificationTemplateEventTypes {
    //Push Notifications
    public static final String AMS_PRE_ORDER_NOTIFY = "AMS_PRE_ORDER_NOTIFY";
    public static final String AMS_ORD_MODIFY = "AMS_ORD_MODIFY";
    public static final String AMS_ORD_CANCELLED = "AMS_ORD_CANCELLED";
    public static final String AMS_ORD_REASSIGN = "AMS_ORD_REASSIGN";
    public static final String AMS_ORD_CREATED = "AMS_ORD_CREATED";
    public static final String AMS_ORD_FULFILLED = "AMS_ORD_FULFILLED";
    public static final String AMS_ORD_REJECTED = "AMS_ORD_RETAILER_DECLINE";
    public static final String AMS_ORD_EXPIRED = "AMS_ORD_EXPIRED";
    public static final String AMS_ORD_PARTIALLY_FULFILLED = "AMS_ORD_PARTIALLY_FULFILLED";
}