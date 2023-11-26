package com.project.datasyncservice.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Arrays;
import java.util.EnumSet;

@ToString
@AllArgsConstructor
@Getter
public enum APACCodesEnum {

    COUNTRY_CODE("country_code", 0),
    COUNTRY_DESC("country_description", 0),

    LEVEL_1_NAME("location_hierarchy_level_1_name", 1),
    LEVEL_3_NAME("location_hierarchy_level_2_name", 2),
    LEVEL_2_NAME("location_hierarchy_level_3_name", 3),
    LEVEL_4_NAME("location_hierarchy_level_4_name", 4),
    LEVEL_5_NAME("location_hierarchy_level_5_name", 5),

    LEVEL_1_CODE("location_hierarchy_level_1_code", 1),
    LEVEL_2_CODE("location_hierarchy_level_2_code", 2),
    LEVEL_3_CODE("location_hierarchy_level_3_code", 3),
    LEVEL_4_CODE("location_hierarchy_level_4_code", 4),
    LEVEL_5_CODE("location_hierarchy_level_5_code", 5),

    LEVEL_1_DESC("location_hierarchy_level_1_desc", 1),
    LEVEL_2_DESC("location_hierarchy_level_2_desc", 2),
    LEVEL_3_DESC("location_hierarchy_level_3_desc", 3),
    LEVEL_4_DESC("location_hierarchy_level_4_desc", 4),
    LEVEL_5_DESC("location_hierarchy_level_5_desc", 5);

    public static final EnumSet<APACCodesEnum> level1APACCodes = EnumSet.of(LEVEL_1_NAME, LEVEL_1_CODE, LEVEL_1_DESC);
    public static final EnumSet<APACCodesEnum> level2APACCodes = EnumSet.of(LEVEL_2_NAME, LEVEL_2_CODE, LEVEL_2_DESC);
    public static final EnumSet<APACCodesEnum> level3APACCodes = EnumSet.of(LEVEL_3_NAME, LEVEL_3_CODE, LEVEL_3_DESC);
    public static final EnumSet<APACCodesEnum> level4APACCodes = EnumSet.of(LEVEL_4_NAME, LEVEL_4_CODE, LEVEL_4_DESC);
    public static final EnumSet<APACCodesEnum> level5APACCodes = EnumSet.of(LEVEL_5_NAME, LEVEL_5_CODE, LEVEL_5_DESC);
    public static final EnumSet<APACCodesEnum> nameAPACCodes = EnumSet.of(LEVEL_5_NAME, LEVEL_4_NAME, LEVEL_3_NAME, LEVEL_2_NAME, LEVEL_1_NAME);
    public static final EnumSet<APACCodesEnum> codeAPACCodes = EnumSet.of(LEVEL_5_CODE, LEVEL_4_CODE, LEVEL_3_CODE, LEVEL_2_CODE, LEVEL_1_CODE);
    public static final EnumSet<APACCodesEnum> descAPACCodes = EnumSet.of(LEVEL_5_DESC, LEVEL_4_DESC, LEVEL_3_DESC, LEVEL_2_DESC, LEVEL_1_DESC);
    public static final EnumSet<APACCodesEnum> level0Codes = EnumSet.of(COUNTRY_CODE, COUNTRY_DESC);

    private final String code;
    private final Integer level;

    public static APACCodesEnum getCodeByKey(String key) {
        return Arrays.stream(APACCodesEnum.values())
                .filter(codesEnum -> codesEnum.getCode().equals(key))
                .findAny().orElse(null);
    }

}
