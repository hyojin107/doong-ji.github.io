package com.doongji.homepage.controller.v1.board.dto;

import com.doongji.homepage.entity.board.AccessType;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
@AllArgsConstructor
public class AccessRequest {

    @ApiModelProperty(value = "게시판 pk 리스트", required = true)
    public List<Long> boardIdList;

    @ApiModelProperty(value = "게시판 접근 범위", required = true)
    public AccessType accessType;

}
