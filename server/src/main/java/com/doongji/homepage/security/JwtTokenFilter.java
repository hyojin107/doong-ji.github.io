package com.doongji.homepage.security;

import com.doongji.homepage.security.jwtAuth.PostAuthorizationToken;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static java.util.Objects.nonNull;
import static java.util.stream.Collectors.toList;

@Slf4j
@RequiredArgsConstructor
public class JwtTokenFilter extends OncePerRequestFilter {

    public final JwtTokenUtil jwtTokenUtil;

    @Override
    public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (SecurityContextHolder.getContext().getAuthentication() == null) {
            String authorizationToken = request.getHeader("Authorization");
            if (authorizationToken != null && authorizationToken.startsWith("Bearer ")) {
                String token = authorizationToken.substring(7);

                jwtTokenClaims jwtTokenClaims = new jwtTokenClaims(jwtTokenUtil, token);
                Long accountId = jwtTokenClaims.getAccountId();
                String email = jwtTokenClaims.getEmail();

                // 만료시간 10분전
                if (canRefresh(jwtTokenClaims.getExp())) {
                    String refreshedToken = jwtTokenUtil.refreshToken(
                            accountId, email,
                            jwtTokenClaims.getRoles(),
                            jwtTokenClaims.getExp()
                    );
                    response.setHeader("Authorization", refreshedToken);
                }

                List<GrantedAuthority> authorities = obtainAuthorities(jwtTokenClaims.getRoles());
                if (nonNull(accountId) && nonNull(email) && authorities.size() > 0) {
                    PostAuthorizationToken postAuthenticated = new PostAuthorizationToken(
                            new JwtAuthentication(accountId, email),
                            null,
                            authorities);
                    postAuthenticated.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(postAuthenticated);
                }
            }
        }
        chain.doFilter(request, response);
    }

    private boolean canRefresh(Date expDate) {
        long exp = expDate != null ? expDate.getTime() : -1;
        if (exp > 0) {
            long remain = exp - System.currentTimeMillis();
            return remain < 6_000L * 10L;
        }
        return false;
    }

    private List<GrantedAuthority> obtainAuthorities(String[] roles) {
        return roles == null || roles.length == 0
                ? Collections.emptyList()
                : Arrays.stream(roles).map(SimpleGrantedAuthority::new).collect(toList());
    }

}
