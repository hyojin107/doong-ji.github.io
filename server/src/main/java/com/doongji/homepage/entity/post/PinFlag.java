package com.doongji.homepage.entity.post;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum PinFlag {

    PIN("고정"),
    UNPIN("비고정");

    private final String value;

    public String value() {
        return value;
    }

    @JsonCreator
    public static PinFlag converter(String pin) {
        return PinFlag.valueOf(pin.toUpperCase());
    }

}
