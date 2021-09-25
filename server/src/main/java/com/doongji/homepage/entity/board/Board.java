package com.doongji.homepage.entity.board;

import com.doongji.homepage.entity.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static org.apache.commons.lang3.StringUtils.isNotEmpty;

@Getter
@Entity
@EqualsAndHashCode(of = "boardId", callSuper = false)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardId;

    private String title;

    private String description;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private BoardType boardType;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private AccessType accessType;

    public Board(String title, String description, BoardType boardType, AccessType accessType) {
        checkArgument(isNotEmpty(title), "title must be provided.");
        checkArgument(isNotEmpty(description), "description must be provided.");
        checkNotNull(boardType, "boardType must be provided.");
        checkNotNull(accessType, "accessScope must be provided.");

        this.title = title;
        this.description = description;
        this.boardType = boardType;
        this.accessType = accessType;
    }

    public void updateBoard(Board board) {
        this.title = board.getTitle();
        this.description = board.getDescription();
        this.boardType = board.getBoardType();
        this.accessType = board.getAccessType();
    }

    public void updateAccessType(AccessType accessType) {
        this.accessType = accessType;
    }

}
