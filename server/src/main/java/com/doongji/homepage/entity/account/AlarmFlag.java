package com.doongji.homepage.entity.account;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum AlarmFlag {

    ON("on"),
    OFF("off");

    private final String value;

    public String value() {
        return value;
    }

    @JsonCreator
    public static AlarmFlag converter(String alarm) {
        return AlarmFlag.valueOf(alarm.toUpperCase());
    }

}
