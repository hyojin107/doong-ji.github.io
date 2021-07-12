package com.doongji.homepage.security;

import lombok.Getter;

import java.util.Date;

@Getter
public class jwtTokenClaims {

    private Long accountId;
    private String email;
    private String[] roles;
    private Date exp;

    public jwtTokenClaims(JwtTokenUtil jwtTokenUtil, String token) {
        accountId = jwtTokenUtil.decodedJwtToken(token).getClaim("accountId").asLong();
        email = jwtTokenUtil.decodedJwtToken(token).getClaim("email").asString();
        roles = jwtTokenUtil.decodedJwtToken(token).getClaim("roles").asArray(String.class);
        exp = jwtTokenUtil.decodedJwtToken(token).getExpiresAt();
    }

}
