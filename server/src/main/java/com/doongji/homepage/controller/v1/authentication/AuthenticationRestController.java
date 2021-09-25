package com.doongji.homepage.controller.v1.authentication;

import com.doongji.homepage.controller.v1.authentication.dto.AuthenticationResultDto;
import com.doongji.homepage.exception.UnauthorizedException;
import com.doongji.homepage.security.AuthenticationRequest;
import com.doongji.homepage.security.AuthenticationResult;
import com.doongji.homepage.security.JwtToken;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "인증 APIs")
@RequestMapping("api/auth")
@RequiredArgsConstructor
@RestController
public class AuthenticationRestController {

    private final AuthenticationManager authenticationManager;

    @ApiOperation(value = "사용자 로그인 (JWT 불필요)")
    @PostMapping
    public ResponseEntity<AuthenticationResultDto> authentication(@RequestBody AuthenticationRequest authRequest) throws UnauthorizedException {
        try {
            JwtToken token = new JwtToken(authRequest.getEmail(), authRequest.getPassword());
            Authentication authentication = authenticationManager.authenticate(token);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            return ResponseEntity.ok(
                    new AuthenticationResultDto((AuthenticationResult) authentication.getDetails())
            );
        } catch (AuthenticationException e) {
            throw new UnauthorizedException(e.getMessage());
        }
    }

}
