package com.doongji.homepage.controller.v1.account.dto;

import com.doongji.homepage.entity.account.Account;
import com.doongji.homepage.entity.account.AlarmFlag;
import com.doongji.homepage.entity.account.Part;
import com.doongji.homepage.entity.account.Role;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import static org.springframework.beans.BeanUtils.copyProperties;

@Getter
@Setter
@ToString
public class AccountDto {

    @ApiModelProperty(value = "PK", required = true)
    private Long accountId;

    @ApiModelProperty(value = "이메일", required = true)
    private String email;

    @ApiModelProperty(value = "사용자명", required = true)
    private String name;

    @ApiModelProperty(value = "닉네임", required = true)
    private String nickname;

    @ApiModelProperty(value = "개발파트", required = true)
    private Part part;

    @ApiModelProperty(value = "자기소개", required = false)
    private String introduce;

    @ApiModelProperty(value = "프로필사진경로", required = false)
    private String profilePath;

    @ApiModelProperty(value = "알람여부", required = false)
    private AlarmFlag alarmFlag;

    @ApiModelProperty(value = "사용자 권한", required = false)
    private Role role;

    public AccountDto(Account source) {
        copyProperties(source, this);
    }

}