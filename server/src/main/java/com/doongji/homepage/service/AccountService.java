package com.doongji.homepage.service;

import com.doongji.homepage.entity.account.AlarmFlag;
import com.doongji.homepage.entity.account.Account;
import com.doongji.homepage.entity.account.Part;
import com.doongji.homepage.entity.account.Role;
import com.doongji.homepage.exception.NotFoundException;
import com.doongji.homepage.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.EnumUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

@RequiredArgsConstructor
@Service
public class AccountService {

    private final AccountRepository accountRepository;

    private final PasswordEncoder passwordEncoder;

    @Transactional
    public Account join(String email, String name, String password, String nickname, Part part) {
        checkNotNull(password, "password must be provided.");
        checkArgument(
                password.length() >= 8 && password.length() <= 15,
                "password length must be between 8 and 15 characters."
        );
        checkNotNull(part, "part must be a valid value.");

        return accountRepository.save(
                Account.builder()
                        .email(email)
                        .name(name)
                        .password(passwordEncoder.encode(password))
                        .nickname(nickname)
                        .part(part)
                        .alarmFlag(AlarmFlag.ON)
                        .role(Role.GUEST)
                        .build()
        );
    }

    @Transactional
    public Account login(String email, String password) {
        checkNotNull(password, "password must be provided.");

        Account account = accountRepository.findByEmail(email)
                .orElseThrow(() -> new NotFoundException(Account.class, email));
        account.login(passwordEncoder, password);
        return account;
    }

}
