package com.doongji.homepage.entity.account;

import com.doongji.homepage.entity.BaseTimeEntity;
import com.doongji.homepage.security.Jwt;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static java.util.regex.Pattern.matches;
import static org.apache.commons.lang3.StringUtils.isNotEmpty;

@Getter
@Entity
@EqualsAndHashCode(of = "accountId", callSuper = false)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class Account extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PartName partName;

    private String introduce;

    private String profilePath;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private AlarmFlag alarmFlag;

    public Account(String email, String name, String password, String nickname, PartName partName, AlarmFlag alarmFlag) {
        this(null, email, name, password, nickname, partName, null, null, alarmFlag);
    }

    public Account(Long accountId, String email, String name, String password, String nickname, PartName partName, String introduce, String profilePath, AlarmFlag alarmFlag) {
        checkArgument(isNotEmpty(email), "email must be provided.");
        checkArgument(
                email.length() >= 4 && email.length() <= 50,
                "email length must be between 4 and 50 characters."
        );
        checkArgument(checkEmail(email), "Invalid email address: " + email);
        checkArgument(isNotEmpty(name), "name must be provided.");
        checkArgument(
                name.length() >= 1 && name.length() <= 10,
                "name length must be between 1 and 10 characters."
        );
        checkNotNull(password, "password must be provided.");
        checkArgument(isNotEmpty(nickname), "nickname must be provided.");

        this.accountId = accountId;
        this.email = email;
        this.name = name;
        this.password = password;
        this.nickname = nickname;
        this.partName = partName;
        this.introduce = introduce;
        this.profilePath = profilePath;
        this.alarmFlag = alarmFlag;
    }

    private static boolean checkEmail(String email) {
        return matches("[\\w~\\-.+]+@[\\w~\\-]+(\\.[\\w~\\-]+)+", email);
    }

    public void login(PasswordEncoder passwordEncoder, String credentials) {
        if (!passwordEncoder.matches(credentials, password))
            throw new IllegalArgumentException("Bad credential");
    }

    public String createToken(Jwt jwt, String[] roles) {
        Jwt.Claims claims = Jwt.Claims.of(accountId, email, roles);
        return jwt.newToken(claims);
    }

}
