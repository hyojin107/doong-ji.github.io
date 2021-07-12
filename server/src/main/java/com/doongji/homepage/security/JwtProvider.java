package com.doongji.homepage.security;

import com.doongji.homepage.entity.account.Account;
import com.doongji.homepage.security.jwtAuth.PostAuthorizationToken;
import com.doongji.homepage.security.jwtAuth.PreAuthorizationToken;
import com.doongji.homepage.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import static org.springframework.security.core.authority.AuthorityUtils.createAuthorityList;

@RequiredArgsConstructor
public class JwtProvider implements AuthenticationProvider {

    private final JwtTokenUtil tokenUtil;

    private final AccountService accountService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        PreAuthorizationToken preToken = (PreAuthorizationToken) authentication;

        Account account = accountService.login(preToken.getUserEmail(), preToken.getUserPassword());
        PostAuthorizationToken postAuthenticated = new PostAuthorizationToken(
                new JwtAuthentication(account.getAccountId(), account.getEmail()),
                null,
                createAuthorityList(account.getRole().name())
        );
        String token = tokenUtil.createToken(
                account.getAccountId(), account.getEmail(), new String[]{account.getRole().name()}
        );

        postAuthenticated.setDetails(new AuthenticationResult(token, account));
        return postAuthenticated;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return PreAuthorizationToken.class.isAssignableFrom(authentication);
    }

}
