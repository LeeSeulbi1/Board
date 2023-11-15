package com.board.board.controller;

import com.board.board.Service.PostService;
import com.board.board.dto.PostAddRequestDto;
import com.board.board.dto.PostResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/posts")
public class PostController {

    private final PostService postService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PostResponseDto addPost(
            @RequestBody PostAddRequestDto requestDto
    ) {
       PostResponseDto responseDto = postService.addPost(requestDto);
       return responseDto;

    }

    @GetMapping("/{postid}")
    public PostResponseDto getPost(
            @PathVariable Long postId
    ){
        return postService.getPost(postId);
    }

    @GetMapping
    public List<PostResponseDto> getPosts() {
        return postService.getPosts();
    }

}
