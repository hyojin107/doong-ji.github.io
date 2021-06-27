package com.doongji.homepage.entity.account;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum PartName {

    PUBLISHING("퍼블리싱"),
    FRONTEND("프론트엔드"),
    SPRING("스프링"),
    NODEJS("노드js"),
    ANDROID("안드로이드"),
    IOS("ios");

    private final String value;

    public String value() {
        return value;
    }

}
