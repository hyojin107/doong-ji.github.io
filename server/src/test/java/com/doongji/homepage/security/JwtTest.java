package com.doongji.homepage.security;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.Date;

import static java.lang.Thread.sleep;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@Slf4j
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
public class JwtTest {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Value("${jwt.token.expirationTime}")
    private long expirySeconds;

    @Test
    void JWT_생성_후_복호화() {
        Long accountId = 1L;
        String email = "doongji.team@gmail.com";
        String[] roles = new String[]{"ROLE_USER"};
        String encodedJWT = jwtTokenUtil.createToken(accountId, email, roles);
        log.info("encodedJWT: {}", encodedJWT);

        jwtTokenClaims decodedJWT = new jwtTokenClaims(jwtTokenUtil, encodedJWT);
        log.info("decodedJWT: {}", decodedJWT);

        assertThat(accountId, is(decodedJWT.getAccountId()));
        assertThat(email, is(decodedJWT.getEmail()));
        assertArrayEquals(roles, decodedJWT.getRoles());
    }

    @Test
    void JWT_갱신() throws Exception {
        if(expirySeconds > 0 ) {
            Long accountId = 1L;
            String email = "doongji.team@gmail.com";
            String[] roles = new String[]{"ROLE_USER"};
            String encodedJWT = jwtTokenUtil.createToken(accountId, email, roles);
            log.info("encodedJWT: {}", encodedJWT);

            // 1초 대기 후 토큰 갱신
            sleep(1_000L);

            String encodedRefreshedJWT = jwtTokenUtil.refreshToken(accountId, email, roles, new Date());
            log.info("encodedRefreshedJWT: {}", encodedRefreshedJWT);

            assertThat(encodedJWT, not(encodedRefreshedJWT));

            jwtTokenClaims oldJwt = new jwtTokenClaims(jwtTokenUtil, encodedJWT);
            jwtTokenClaims newJwt = new jwtTokenClaims(jwtTokenUtil, encodedRefreshedJWT);

            long oldExp = oldJwt.getExp().getTime();
            long newExp = newJwt.getExp().getTime();

            // 1초 대기 후 토큰 갱신했기 때문에 만료시간 차이는 1초 이상
            assertThat(newExp >= oldExp + 1_000L, is(true));

            log.info("oldJwt: {}", oldJwt);
            log.info("newJwt: {}", newJwt);
        }
    }

}
