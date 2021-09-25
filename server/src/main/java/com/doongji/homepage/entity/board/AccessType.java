package com.doongji.homepage.entity.board;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum AccessType {

    PUBLIC("공개"),
    PRIVATE("비공개");

    private final String value;

    public String value() {
        return value;
    }

    @JsonCreator
    public static AccessType converter(String access) {
        return AccessType.valueOf(access.toUpperCase());
    }

}
