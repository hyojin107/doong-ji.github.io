package com.doongji.homepage.entity.post;

import com.doongji.homepage.entity.BaseTimeEntity;
import com.doongji.homepage.entity.account.Account;
import com.doongji.homepage.entity.board.Board;
import lombok.*;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static org.apache.commons.lang3.StringUtils.isNotEmpty;

import javax.persistence.*;

@Getter
@Entity
@EqualsAndHashCode(of = "postId", callSuper = false)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(exclude = {"board", "account"})
public class Post extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    private String title;

    private String content;

    private int viewCount;

    private int commentCount;

    private int reportCount;

    @Enumerated(EnumType.STRING)
    private PinFlag pinFlag;

    @Enumerated(EnumType.STRING)
    private PostType postType;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "board_id")
    private Board board;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "account_id")
    private Account account;

    @Builder
    public Post(Long postId, String title, String content, int viewCount, int commentCount, int reportCount, PinFlag pinFlag, Board board, Account account) {
        checkArgument(isNotEmpty(title), "title must be provided.");
        checkArgument(isNotEmpty(content), "content must be provided.");
        checkNotNull(pinFlag, "pinFlag must be provided.");
        checkNotNull(postType, "postType must be provided.");
        checkNotNull(account.getAccountId(), "accountId must be provided.");
        checkNotNull(board.getBoardId(), "boardId must be provided.");


        this.postId = postId;
        this.title = title;
        this.content = content;
        this.viewCount = viewCount;
        this.commentCount = commentCount;
        this.reportCount = reportCount;
        this.pinFlag = pinFlag;
        this.postType = postType;
        this.board = board;
        this.account = account;
    }

    public void updatePost(String title, String content, PinFlag pinFlag) {
        this.title = title;
        this.content = content;
        this.pinFlag = pinFlag;
    }

    public int incrementViewCount() {
        return ++this.viewCount;
    }

}
