package com.doongji.homepage.security;

import com.doongji.homepage.entity.account.Account;
import lombok.Getter;
import lombok.ToString;

import static com.google.common.base.Preconditions.checkNotNull;

@Getter
@ToString
public class AuthenticationResult {

    private final String token;

    private final Account account;

    public AuthenticationResult(String token, Account account) {
        checkNotNull(token, "token must be provided.");
        checkNotNull(account, "account must be provided.");

        this.token = token;
        this.account = account;
    }

}