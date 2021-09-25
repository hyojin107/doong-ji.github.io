package com.doongji.homepage.entity.board;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum BoardType {

    NOTICE("공지사항"),
    GENERAL("일반");

    private final String value;

    public String value() {
        return value;
    }

    @JsonCreator
    public static BoardType converter(String type) {
        return BoardType.valueOf(type.toUpperCase());
    }

}
