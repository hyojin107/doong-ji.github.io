package com.doongji.homepage.controller.v1.authentication.dto;

import com.doongji.homepage.controller.v1.account.dto.AccountDto;
import com.doongji.homepage.security.AuthenticationResult;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import static org.springframework.beans.BeanUtils.copyProperties;

@Getter
@Setter
@ToString
public class AuthenticationResponse {

    @ApiModelProperty(value = "API 토큰", required = true)
    private String token;

    @ApiModelProperty(value = "사용자 정보", required = true)
    private AccountDto account;

    public AuthenticationResponse(AuthenticationResult source) {
        copyProperties(source, this);

        this.account = new AccountDto(source.getAccount());
    }

}