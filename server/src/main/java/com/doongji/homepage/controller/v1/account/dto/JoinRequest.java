package com.doongji.homepage.controller.v1.account.dto;

import com.doongji.homepage.entity.account.Part;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class JoinRequest {

    @ApiModelProperty(value = "이메일", required = true)
    private String email;

    @ApiModelProperty(value = "사용자명", required = true)
    private String name;

    @ApiModelProperty(value = "로그인 비밀번호", required = true)
    private String password;

    @ApiModelProperty(value = "닉네임", required = true)
    private String nickname;

    @ApiModelProperty(value = "개발파트", required = true)
    private Part part;

}
