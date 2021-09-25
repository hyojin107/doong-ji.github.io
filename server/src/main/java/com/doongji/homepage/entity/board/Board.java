package com.doongji.homepage.entity.board;

import com.doongji.homepage.entity.BaseTimeEntity;
import lombok.*;

import javax.persistence.*;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static org.apache.commons.lang3.StringUtils.isNotEmpty;

@ToString
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

    @Builder
    public Board(Long boardId, String title, String description, BoardType boardType, AccessType accessType) {
        checkArgument(isNotEmpty(title), "title must be provided.");
        checkArgument(isNotEmpty(description), "description must be provided.");
        checkNotNull(boardType, "boardType must be provided.");
        checkNotNull(accessType, "accessType must be provided.");

        this.boardId = boardId;
        this.title = title;
        this.description = description;
        this.boardType = boardType;
        this.accessType = accessType;
    }

    public void updateBoard(String title, String description, BoardType boardType) {
        this.title = title;
        this.description = description;
        this.boardType = boardType;
    }

    public void updateAccessType(AccessType accessType) {
        this.accessType = accessType;
    }

}
