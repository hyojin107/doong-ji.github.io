package com.doongji.homepage.controller.v1.post.dto;

import com.doongji.homepage.controller.v1.account.dto.AccountDto;
import com.doongji.homepage.entity.board.Board;
import com.doongji.homepage.entity.post.PinFlag;
import com.doongji.homepage.entity.post.Post;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

import static org.springframework.beans.BeanUtils.copyProperties;

@Getter
@Setter
@ToString
public class PostDto {

    @ApiModelProperty(value = "PK", required = true)
    public Long postId;

    @ApiModelProperty(value = "게시글 제목", required = true)
    public String title;

    @ApiModelProperty(value = "내용", required = true)
    public String content;

    @ApiModelProperty(value = "조회수", required = false)
    public int viewCount;

    @ApiModelProperty(value = "신고 횟수", required = false)
    public int reportCount;

    @ApiModelProperty(value = "고정 여부", required = false)
    public PinFlag pinFlag;

    @ApiModelProperty(value = "해당 게시판", required = true)
    public Board board;

    @ApiModelProperty(value = "게시글 작성자", required = true)
    public AccountDto account;

    @ApiModelProperty(value = "작성일", required = true)
    public LocalDateTime createdDate;

    @ApiModelProperty(value = "수정일", required = false)
    public LocalDateTime modifiedDate;

    public PostDto(Post source) {
        copyProperties(source, this);
    }

}
