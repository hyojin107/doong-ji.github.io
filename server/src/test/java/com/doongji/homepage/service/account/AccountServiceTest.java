package com.doongji.homepage.service.account;

import com.doongji.homepage.entity.account.Account;
import com.doongji.homepage.entity.account.AlarmFlag;
import com.doongji.homepage.entity.account.Part;
import com.doongji.homepage.entity.account.Role;
import com.doongji.homepage.repository.AccountRepository;
import com.doongji.homepage.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.times;

@Slf4j
@ExtendWith(MockitoExtension.class)
public class AccountServiceTest {

    @InjectMocks
    private AccountService accountService;

    @Mock
    private AccountRepository accountRepository;

    @Mock
    public PasswordEncoder passwordEncoder;

    @Test
    void 사용자_회원가입() {
        // given
        String name = "둥지";
        String email = "doongji.team@gmail.com";
        String password = "Ppp@ssword1";
        String nickname = "둥지닉넴";
        Part part = Part.BACKEND;
        Account account = Account.builder()
                .email(email)
                .name(name)
                .password(password)
                .nickname(nickname)
                .part(part)
                .alarmFlag(AlarmFlag.ON).role(Role.GUEST).build();

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
        String name = "둥지";
        String email = "doongji.team@gmail.com";
        String password = "$2a$10$q8s1Yw4zGU7ky5S9oBDEYuj.FnOqNUi180YQZVbgIeg1CI3Fj2NzO";
        String nickname = "둥지닉넴";
        Part part = Part.BACKEND;
        Account account = Account.builder()
                .accountId(1L)
                .password(password)
                .email(email)
                .name(name).nickname(nickname).part(Part.BACKEND).alarmFlag(AlarmFlag.ON).role(Role.USER).build();

        given(passwordEncoder.matches(any(), any())).willReturn(true);
        given(accountRepository.findByEmail(email)).willReturn(java.util.Optional.of(account));

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
