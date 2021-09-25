package com.doongji.homepage.controller.v1.board.dto;

import com.doongji.homepage.entity.board.BoardType;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class BoardRequest {

    @ApiModelProperty(value = "게시판 이름", required = true)
    public String title;

    @ApiModelProperty(value = "게시판 설명", required = true)
    public String description;

    @ApiModelProperty(value = "게시판 유형", required = true)
    public BoardType boardType;

}
