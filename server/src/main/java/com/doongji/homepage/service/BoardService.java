package com.doongji.homepage.service;

import com.doongji.homepage.entity.board.AccessType;
import com.doongji.homepage.entity.board.Board;
import com.doongji.homepage.entity.board.BoardType;
import com.doongji.homepage.exception.NotFoundException;
import com.doongji.homepage.repository.BoardRepository;
import com.doongji.homepage.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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

    @Transactional
    public Board register(String title, String description, BoardType boardType) {
        return boardRepository.save(
                new Board(title, description, boardType, AccessType.PUBLIC)
        );
    }

    @Transactional
    public Board update(Long id, String title, String description, BoardType boardType) {
        return boardRepository.findById(id)
                .map(board ->{
                    board.updateBoard(board);
                    return board;
                })
                .orElseThrow(() -> new NotFoundException(Board.class, id));
    }


}
