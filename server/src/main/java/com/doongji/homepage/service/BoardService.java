package com.doongji.homepage.service;

import com.doongji.homepage.entity.board.Board;
import com.doongji.homepage.exception.NotFoundException;
import com.doongji.homepage.repository.BoardRepository;
import com.doongji.homepage.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;
    private final PostRepository postRepository;

    public List<Board> list() {
        return boardRepository.findAll();
    }

    public Board findById(Long boardId) {
        return boardRepository.findById(boardId)
                .orElseThrow(() -> new NotFoundException(Board.class, boardId));
    }

}
