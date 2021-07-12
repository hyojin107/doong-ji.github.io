package com.doongji.homepage.controller.v1.account;

import com.doongji.homepage.controller.v1.account.dto.AccountDto;
import com.doongji.homepage.controller.v1.account.dto.JoinRequest;
import com.doongji.homepage.controller.v1.account.dto.JoinResult;
import com.doongji.homepage.entity.account.Account;
import com.doongji.homepage.entity.account.Role;
import com.doongji.homepage.security.JwtTokenUtil;
import com.doongji.homepage.service.AccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "사용자 APIs")
@RequestMapping("api/v1")
@RequiredArgsConstructor
@RestController
public class AccountController {

    private final AccountService accountService;

    private final JwtTokenUtil jwtTokenUtil;

    @ApiOperation(value = "사용자 등록 (JWT 불필요)")
    @PostMapping(path = "user/join")
    public ResponseEntity<JoinResult> join(@RequestBody JoinRequest joinRequest) {
        Account user = accountService.join(
                joinRequest.getEmail(),
                joinRequest.getName(),
                joinRequest.getPassword(),
                joinRequest.getNickname(),
                joinRequest.getPart()
        );
        String token = jwtTokenUtil.createToken(user.getAccountId(), user.getEmail(), new String[]{Role.GUEST.value()});
        return ResponseEntity.ok(new JoinResult(token, new AccountDto(user)));
    }

}
