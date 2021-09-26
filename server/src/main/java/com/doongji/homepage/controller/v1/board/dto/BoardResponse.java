package com.doongji.homepage.controller.v1.board.dto;

import com.doongji.homepage.entity.board.AccessType;
import com.doongji.homepage.entity.board.Board;
import com.doongji.homepage.entity.board.BoardType;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import static org.springframework.beans.BeanUtils.copyProperties;

@Getter
@Setter
@ToString
public class BoardResponse {

    @ApiModelProperty(value = "PK", required = true)
    public Long boardId;

    @ApiModelProperty(value = "게시판 이름", required = true)
    public String title;

    @ApiModelProperty(value = "게시판 설명", required = true)
    public String description;

    @ApiModelProperty(value = "게시판 유형", required = true)
    public BoardType boardType;

    @ApiModelProperty(value = "게시판 접근 범위", required = true)
    public AccessType accessType;

    public BoardResponse(Board source) {
        copyProperties(source, this);
    }

}
