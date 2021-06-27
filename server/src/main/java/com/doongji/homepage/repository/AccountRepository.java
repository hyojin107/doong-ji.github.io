package com.doongji.homepage.repository;

import com.doongji.homepage.entity.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {

    Optional<Account> findById(Long accountId);
    Optional<Account> findByEmail(String email);

}
