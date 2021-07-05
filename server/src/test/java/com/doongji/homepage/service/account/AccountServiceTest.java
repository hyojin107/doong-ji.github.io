package com.doongji.homepage.service.account;

import com.doongji.homepage.entity.account.Account;
import com.doongji.homepage.entity.account.AlarmFlag;
import com.doongji.homepage.entity.account.Part;
import com.doongji.homepage.entity.account.Role;
import com.doongji.homepage.repository.AccountRepository;
import com.doongji.homepage.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.times;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Slf4j
public class AccountServiceTest {

    @InjectMocks
    private AccountService accountService;

    @Mock
    private AccountRepository accountRepository;

    @Mock
    public PasswordEncoder passwordEncoder;

    private String email;

    private String name;

    private String password;

    private String nickname;

    private Part part;

    private Account account;

    @BeforeAll
    void setUp() {
        name = "둥지";
        email = "doongji.team@gmail.com";
        password = "Ppp@ssword1";
        nickname = "둥지닉넴";
        part = Part.BACKEND;
        account = new Account(null, email, name, password, nickname,
                part, null, null, AlarmFlag.ON, Role.GUEST);
    }

    @Test
    void 사용자_회원가입() {
        // given
        given(passwordEncoder.encode(anyString())).willReturn(password);
        given(accountRepository.save(any(Account.class))).willReturn(account);

        // when
        Account resultAccount = accountService.join(email, name, password, nickname, part);

        // then
        then(accountRepository).should(times(1)).save(account);
        assertThat(resultAccount).isNotNull();
        assertThat(resultAccount.getEmail()).isEqualTo(email);
        assertThat(resultAccount.getName()).isEqualTo(name);
        assertThat(resultAccount.getNickname()).isEqualTo(nickname);
        assertThat(resultAccount.getRole()).isEqualTo(Role.GUEST);
        log.info("Account: {}", account);
    }

    @Test
    void 사용자_로그인() {
        // given
        given(passwordEncoder.encode(anyString())).willReturn(password);
        given(passwordEncoder.matches(any(), any())).willReturn(true);
        given(accountRepository.findByEmail(anyString())).willReturn(java.util.Optional.of(account));

        // when
        Account resultAccount = accountService.login(email, password);

        // then
        assertThat(resultAccount).isNotNull();
        assertThat(resultAccount.getEmail()).isEqualTo(email);
        assertThat(resultAccount.getName()).contains(name);
        assertThat(resultAccount.getNickname()).contains(nickname);
        assertThat(resultAccount.getPart()).isEqualTo(part);
        log.info("Login User: {}", resultAccount);
    }

}
