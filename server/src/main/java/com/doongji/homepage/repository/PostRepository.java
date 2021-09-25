package com.doongji.homepage.repository;

import com.doongji.homepage.entity.board.Board;
import com.doongji.homepage.entity.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

    void deleteByBoard(Board board);

}
