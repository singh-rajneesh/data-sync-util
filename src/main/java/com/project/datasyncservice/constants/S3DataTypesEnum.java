package com.project.datasyncservice.constants;

import com.project.datasyncservice.exception.DataSyncFileFormatException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Arrays;
import java.util.Objects;

@ToString
@AllArgsConstructor
@Getter
public enum S3DataTypesEnum {

    ADVISOR_DATA("advisor"),
    ORDER_DATA("order"),
    FARMER_DATA("farmer"),

    //not exposed through pre-signed url
    PRODUCT_DATA("product"),
    TRANSLATION("translation");


    private final String dataContext;

    public static S3DataTypesEnum getDataTypeByContext(String dataContext) {
        if (Objects.isNull(dataContext)) {
            throw new DataSyncFileFormatException(ExceptionConstants.DATA_SYNC_FILE_FORMAT_ERROR);
        }
        return Arrays.stream(S3DataTypesEnum.values())
                .filter(dataTypesEnum -> dataTypesEnum.getDataContext().equals(dataContext))
                .findAny().orElseThrow(() -> {
                    throw new DataSyncFileFormatException(ExceptionConstants.DATA_SYNC_FILE_FORMAT_ERROR);
                });
    }

}
