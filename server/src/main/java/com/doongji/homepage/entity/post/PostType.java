package com.doongji.homepage.entity.post;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum PostType {

    NOTICE("공지"),
    VOTE("투표"),
    MEETING("회의");

    private final String value;

    public String value() {
        return value;
    }

    @JsonCreator
    public static PostType converter(String type) {
        return PostType.valueOf(type.toUpperCase());
    }

}
