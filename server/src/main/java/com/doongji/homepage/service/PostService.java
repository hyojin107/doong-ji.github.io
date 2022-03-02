package com.doongji.homepage.service;

import com.doongji.homepage.entity.post.Post;
import com.doongji.homepage.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;
    private final BoardService boardService;

    public Page<Post> list(Long boardId, String title, Pageable pageable) {
        return postRepository.findByBoardAndTitleContains(
                boardService.findById(boardId), title, pageable
        );
    }

}
