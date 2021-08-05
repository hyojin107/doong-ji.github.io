package com.doongji.homepage.entity.account;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Part {

    PUBLISHING("퍼블리싱"),
    FRONTEND("프론트엔드"),
    BACKEND("백엔드"),
    ANDROID("안드로이드"),
    IOS("ios"),
    ETC("기타");

    private final String value;

    public String value() {
        return value;
    }

    @JsonCreator
    public static Part converter(String part) {
        return Part.valueOf(part.toUpperCase());
    }

}
