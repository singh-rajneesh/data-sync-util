package com.project.datasyncservice.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Arrays;

@ToString
@AllArgsConstructor
@Getter
public enum AMSLanguageMappingEnum {

    ENGLISH("english", 1),
    HINDI("hindi", 2),
    KANNADA("kannada", 3),
    ODIA("odiya", 7),
    TAMIL("tamil", 10),
    MARATHI("marathi", 4);


    private final String amsLanguage;
    private final Integer farmriseLanguageId;

    public static Integer getLanguageId(String amsLanguage) {
        return Arrays.stream(AMSLanguageMappingEnum.values())
                .filter(languageMapping -> languageMapping.getAmsLanguage().equals(amsLanguage))
                .map(AMSLanguageMappingEnum::getFarmriseLanguageId)
                .findAny().orElse(AMSLanguageMappingEnum.ENGLISH.getFarmriseLanguageId());
    }
}
