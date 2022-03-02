package com.doongji.homepage.controller.v1.post;

import com.doongji.homepage.controller.v1.post.dto.PostDto;
import com.doongji.homepage.service.PostService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Api(tags = "포스트 APIs")
@RequestMapping("api/v1")
@RequiredArgsConstructor
@Controller
public class PostController {

    private final PostService postService;

    @ApiOperation(value = "포스트 목록")
    @GetMapping("post/list")
    public ResponseEntity<Page<PostDto>> list(Long boardId, Pageable pageable, @RequestParam(required = false, defaultValue = "") String title) {
        return ResponseEntity.ok(
                postService.list(boardId, title, pageable).map(PostDto::new)
        );
    }

}
