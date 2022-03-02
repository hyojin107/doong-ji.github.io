package com.doongji.homepage.entity.post;

import com.doongji.homepage.entity.account.Account;
import lombok.*;

import javax.persistence.*;

@Getter
@Entity
@EqualsAndHashCode(of = "viewersId", callSuper = false)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class Viewers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long viewersId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Account account;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    public Viewers(Account account, Post post) {
        this.account = account;
        this.post = post;
    }

}
