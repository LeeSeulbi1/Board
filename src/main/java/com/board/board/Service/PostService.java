package com.board.board.Service;

import com.board.board.dto.PostAddRequestDto;
import com.board.board.dto.PostResponseDto;
import com.board.board.entity.PostEntity;
import com.board.board.repository.PostJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostJpaRepository postJpaRepository;
    public PostResponseDto addPost(PostAddRequestDto requestDto) {
        PostEntity postEntity = new PostEntity(requestDto);
        PostEntity savePost = postJpaRepository.save(postEntity);

        return new PostResponseDto(savePost);
    }

    public PostResponseDto getPost(Long postId) {
       PostEntity postEntity = postJpaRepository.findById(postId)
                .orElseThrow(()-> new NullPointerException("해당 게시글을 찾을 수 없습니다."));

       return new PostResponseDto(postEntity);
    }

    public List<PostResponseDto> getPosts() {
        return postJpaRepository.findAllBydOrderByCreatedAtDesc().stream()
                .map(PostResponseDto::new).collect(Collectors.toList());
    }
}
