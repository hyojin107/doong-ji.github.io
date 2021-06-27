package com.doongji.homepage.entity.account;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum AlarmFlag {

    ON("on"),
    OFF("off");

    private final String value;

    public String value() {
        return value;
    }

}
