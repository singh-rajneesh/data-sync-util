package com.project.datasyncservice.constants;

import lombok.Getter;

@Getter
public enum LanguageEnum {
    EN(1),
    HI(2),
    KN(3),
    MR(4),
    TE(5),
    GU(6),
    OR(7),
    PA(8),
    BN(9),
    TA(10);

    private final Integer languageId;

    LanguageEnum(final Integer languageId) {
        this.languageId = languageId;
    }

    public static String getNameByLanguageId(Integer languageId) {
        for (LanguageEnum language : LanguageEnum.values()) {
            if (language.getLanguageId().equals(languageId)) {
                return language.name();
            }
        }
        return null;
    }

}