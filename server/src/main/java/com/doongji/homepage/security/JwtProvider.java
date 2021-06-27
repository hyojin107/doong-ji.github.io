package com.doongji.homepage.security;

import com.doongji.homepage.entity.account.Role;
import com.doongji.homepage.entity.account.Account;
import com.doongji.homepage.exception.NotFoundException;
import com.doongji.homepage.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import static org.apache.commons.lang3.ClassUtils.isAssignable;
import static org.springframework.security.core.authority.AuthorityUtils.createAuthorityList;

@RequiredArgsConstructor
@Component
public class JwtProvider implements AuthenticationProvider {

    private final Jwt jwt;

    private final AccountService accountService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        JwtToken jwtToken = (JwtToken) authentication;
        return processUserAuthentication(jwtToken.authenticationRequest());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return isAssignable(JwtToken.class, authentication);
    }

    private Authentication processUserAuthentication(AuthenticationRequest request) {
        try {
            Account account = accountService.login(request.getEmail(), request.getPassword());
            JwtToken authenticated = new JwtToken(
                    new JwtAuthentication(account.getAccountId(), account.getEmail()),
                    null,
                    createAuthorityList(Role.valueOf(account.getRole().value()).value())
            );
            String token = account.createToken(jwt, new String[]{Role.valueOf(account.getRole().value()).value()});
            authenticated.setDetails(new AuthenticationResult(token, account));
            return authenticated;
        } catch (NotFoundException e) {
            throw new UsernameNotFoundException(e.getMessage());
        } catch (IllegalArgumentException e) {
            throw new BadCredentialsException(e.getMessage());
        } catch (DataAccessException e) {
            throw new AuthenticationServiceException(e.getMessage(), e);
        }
    }

}
