package com.doongji.homepage.config;

import com.doongji.homepage.entity.account.Role;
import com.doongji.homepage.security.*;
import com.doongji.homepage.security.fail.UnauthorizedEntryPoint;
import com.doongji.homepage.security.fail.JwtAccessDeniedHandler;
import com.doongji.homepage.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final JwtTokenUtil jwtTokenUtil;

    private final JwtAccessDeniedHandler accessDeniedHandler;

    private final UnauthorizedEntryPoint unauthorizedHandler;

    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/swagger-ui/**", "/swagger-resources/**", "/api-docs", "/webjars/**", "/static/**", "/templates/**", "/h2/**", "/h2-console/**");
    }

    @Bean
    public JwtTokenFilter jwtAuthenticationTokenFilter() {
        return new JwtTokenFilter(jwtTokenUtil);
    }

    @Autowired
    public void configureAuthentication(AuthenticationManagerBuilder builder, JwtProvider jwtProvider) {
        builder.authenticationProvider(jwtProvider);
    }

    @Bean
    public JwtProvider jwtAuthenticationProvider(JwtTokenUtil jwtTokenUtil, AccountService accountService) {
        return new JwtProvider(jwtTokenUtil, accountService);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf()
                .disable()
            .headers()
                .disable()
            .exceptionHandling()
                .accessDeniedHandler(accessDeniedHandler)
                .authenticationEntryPoint(unauthorizedHandler)
                .and()
            .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
            .authorizeRequests()
                .antMatchers("/api/auth").permitAll()
                .antMatchers("/api/v?/main-data").permitAll()
                .antMatchers("/api/v?/user/join").permitAll()
                .antMatchers("/api/v?/post/**").hasAnyRole(Role.USER.name(), Role.ADMIN.name())
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .disable()
            .addFilterBefore(jwtAuthenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class);
    }

}
