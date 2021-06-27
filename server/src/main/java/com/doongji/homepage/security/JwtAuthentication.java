package com.doongji.homepage.security;

import static com.google.common.base.Preconditions.checkNotNull;

public class JwtAuthentication {

    public final Long accountId;

    public final String email;

    JwtAuthentication(Long accountId, String email) {
        checkNotNull(accountId, "userId must be provided.");
        checkNotNull(email, "email must be provided.");

        this.accountId = accountId;
        this.email = email;
    }

}