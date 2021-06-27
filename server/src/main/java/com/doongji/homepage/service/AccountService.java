package com.doongji.homepage.service;

import com.doongji.homepage.entity.account.AlarmFlag;
import com.doongji.homepage.entity.account.Account;
import com.doongji.homepage.entity.account.PartName;
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
    public Account join(String email, String name, String password, String nickname, String partName) {
        checkNotNull(password, "password must be provided.");
        checkArgument(
                password.length() >= 8 && password.length() <= 15,
                "password length must be between 8 and 15 characters."
        );
        checkArgument(EnumUtils.isValidEnumIgnoreCase(PartName.class, partName), "partName must be a valid value.");

        return accountRepository.save(
                new Account(
                        email, name, passwordEncoder.encode(password), nickname, PartName.valueOf(partName.toUpperCase()), AlarmFlag.ON
                )
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
