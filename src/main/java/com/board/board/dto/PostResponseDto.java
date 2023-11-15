package com.board.board.dto;

import com.board.board.entity.PostEntity;

import java.time.LocalDateTime;

public record PostResponseDto (
    Long id,
    String title,
    String author,
    String content,
    LocalDateTime createdAt
) {
    public PostResponseDto(PostEntity savePost) {
        this(
                savePost.getId(),
                savePost.getTitle(),
                savePost.getAuthor(),
                savePost.getContents(),
                savePost.getCreatedAt()
        );
    }
}
