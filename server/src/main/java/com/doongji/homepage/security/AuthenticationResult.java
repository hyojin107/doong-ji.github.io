package com.doongji.homepage.security;

import com.doongji.homepage.entity.account.Account;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.ToString;

import static com.google.common.base.Preconditions.checkNotNull;

@Getter
@ToString
public class AuthenticationResult {

    @ApiModelProperty(value = "API 토큰", required = true)
    private final String token;

    @ApiModelProperty(value = "사용자 정보", required = true)
    private final Account account;

    public AuthenticationResult(String token, Account account) {
        checkNotNull(token, "token must be provided.");
        checkNotNull(account, "account must be provided.");

        this.token = token;
        this.account = account;
    }

}