package com.doongji.homepage.controller.v1.account.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.ToString;

import static com.google.common.base.Preconditions.checkNotNull;

@Getter
@ToString
public class JoinResult {

    @ApiModelProperty(value = "API 토큰", required = true)
    private final String token;

    @ApiModelProperty(value = "사용자 정보", required = true)
    private final AccountDto account;

    public JoinResult(String token, AccountDto account) {
        checkNotNull(token, "token must be provided.");
        checkNotNull(account, "account must be provided.");

        this.token = token;
        this.account = account;
    }

}
