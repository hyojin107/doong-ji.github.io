package com.doongji.homepage.service.account;

import com.doongji.homepage.entity.account.Account;
import com.doongji.homepage.entity.account.PartName;
import com.doongji.homepage.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AccountServiceTest {

    @Autowired
    private AccountService accountService;

    private String email;

    private String name;

    private String password;

    private String nickname;

    private String partName;

    @BeforeAll
    void setUp() {
        name = "둥지";
        email = "doongji.team@gmail.com";
        password = "Ppp@ssword1";
        nickname = "둥지닉넴";
        partName = "spring";
    }
    @Test
    @Order(1)
    void 사용자_회원가입() {
        Account account = accountService.join(email, name, password, nickname, partName);
        assertThat(account).isNotNull();
        assertThat(account.getEmail()).isEqualTo(email);
        assertThat(account.getName()).contains(name);
        assertThat(account.getNickname()).contains(nickname);
        assertThat(account.getPartName()).isEqualTo(PartName.valueOf(partName.toUpperCase()));
        log.info("Account: {}", account);
    }

    @Test
    @Order(2)
    void 사용자_로그인() {
        Account account = accountService.login(email, password);
        assertThat(account).isNotNull();
        assertThat(account.getEmail()).isEqualTo(email);
        assertThat(account.getName()).contains(name);
        assertThat(account.getNickname()).contains(nickname);
        assertThat(account.getPartName()).isEqualTo(PartName.valueOf(partName.toUpperCase()));
        log.info("Login User: {}", account);
    }

}
