package com.doongji.homepage.controller.v1.board;

import com.doongji.homepage.controller.v1.board.dto.BoardRequest;
import com.doongji.homepage.controller.v1.board.dto.BoardResponse;
import com.doongji.homepage.service.BoardService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Api(tags = "게시판 APIs")
@RequestMapping("api/v1")
@RequiredArgsConstructor
@Controller
public class BoardController {

    private final BoardService boardService;

    @ApiOperation(value = "게시판 목록")
    @GetMapping("board")
    public ResponseEntity<List<BoardResponse>> list() {
        return ResponseEntity.ok(
                boardService.list().stream()
                        .map(BoardResponse::new)
                        .collect(Collectors.toList())
        );
    }

    @ApiOperation(value = "게시판 상세 조회")
    @GetMapping("board/{boardId}")
    public ResponseEntity<BoardResponse> board(@PathVariable Long boardId) {
        return ResponseEntity.ok(
                new BoardResponse(boardService.findById(boardId))
        );
    }

    @ApiOperation(value = "게시판 등록")
    @PostMapping("board")
    public ResponseEntity<BoardResponse> boardRegister(@RequestBody BoardRequest boardRequest) {
        return ResponseEntity.ok(
                new BoardResponse(boardService.register(
                        boardRequest.title, boardRequest.description, boardRequest.boardType)
                )
        );
    }

    @ApiOperation(value = "게시판 수정")
    @PutMapping("board/{boardId}")
    public ResponseEntity<BoardResponse> boardUpdate(@PathVariable Long boardId, @RequestBody BoardRequest boardRequest) {
        return ResponseEntity.ok(
                new BoardResponse(boardService.update(
                        boardId, boardRequest.getTitle(), boardRequest.getDescription(), boardRequest.getBoardType()
                ))
        );
    }

    @ApiOperation(value = "게시판 삭제 (해당 포스트도 함께 삭제)")
    @DeleteMapping("board/{boardId}")
    public ResponseEntity<Void> boardDelete(@PathVariable Long boardId) {
        boardService.remove(boardId);
        return ResponseEntity.noContent().build();
    }

}
