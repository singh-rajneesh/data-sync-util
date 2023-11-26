package com.project.datasyncservice.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Arrays;

@ToString
@AllArgsConstructor
@Getter
public enum StaticContentTypeEnum {

    FAQ("FAQ");

    private final String staticContentType;


    public static StaticContentTypeEnum getStaticContentType(String staticContentType) {
        return Arrays.stream(StaticContentTypeEnum.values())
                .filter(statusEnum -> statusEnum.getStaticContentType().equals(staticContentType))
                .findAny().orElse(null);
    }
}
