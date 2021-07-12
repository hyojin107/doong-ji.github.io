package com.doongji.homepage.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenUtil {

    @Value("${jwt.token.issuer}")
    private String issuer;

    @Value("${jwt.token.secret}")
    private String secret;

    @Value("${jwt.token.expirationTime}")
    private long expirationTime;

    public String createToken(Long accountId, String email, String[] roles) {
        return newToken(accountId, email, roles);
    }

    public String newToken(Long accountId, String email, String[] roles) {
        Date now = new Date();
        JWTCreator.Builder builder = JWT.create();
        if (expirationTime > 0) {
            builder.withExpiresAt(new Date(now.getTime() +  expirationTime * 1_000L));
        }
        return builder
                .withIssuer(issuer)
                .withIssuedAt(now)
                .withClaim("accountId", accountId)
                .withClaim("email", email)
                .withArrayClaim("roles", roles)
                .sign(Algorithm.HMAC512(secret));
    }

    public String refreshToken(Long accountId, String email, String[] roles, Date exp) throws JWTVerificationException {
        expirationTime = exp != null ? exp.getTime() : -1;
        return newToken(accountId, email, roles);
    }

    public DecodedJWT decodedJwtToken(String token) {
        return JWT.require(Algorithm.HMAC512(secret))
                .withIssuer(issuer)
                .build()
                .verify(token);
    }

}
