package com.doongji.homepage.service.board;

import com.doongji.homepage.entity.board.AccessType;
import com.doongji.homepage.entity.board.Board;
import com.doongji.homepage.entity.board.BoardType;
import com.doongji.homepage.repository.BoardRepository;
import com.doongji.homepage.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@Slf4j
@ExtendWith(MockitoExtension.class)
public class BoardServiceTest {

    @InjectMocks
    private BoardService boardService;

    @Mock
    private BoardRepository boardRepository;

    @Test
    void 게시판_목록_조회() {
        // given
        Board board1 = Board.builder().boardId(1L)
                .title("제목1").description("설명1").boardType(BoardType.NOTICE).accessType(AccessType.PUBLIC).build();
        Board board2 = Board.builder().boardId(2L)
                .title("제목2").description("설명2").boardType(BoardType.GENERAL).accessType(AccessType.PRIVATE).build();
        List<Board> boardList = Arrays.asList(board1, board2);
        given(boardRepository.findAll()).willReturn(boardList);

        // when
        List<Board> boards = boardService.list();

        // then
        assertThat(boards).isNotNull();
        assertThat(boards.size()).isEqualTo(2);
        log.info("board list: {}", boards);
    }

}
