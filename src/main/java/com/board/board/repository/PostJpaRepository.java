package com.board.board.repository;

import com.board.board.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostJpaRepository extends JpaRepository<PostEntity, Long> {
    List<PostEntity> findAllBydOrderByCreatedAtDesc();
}
