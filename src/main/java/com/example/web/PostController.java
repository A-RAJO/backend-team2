package com.example.web;

import com.example.repository.Post;
import com.example.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api")
public class PostController {
    private final PostService postService;

    //모든 게시물 조회
    @GetMapping("/posts")
    public List<Post> findAllPost(){
        List<Post> posts=PostService.findAllPost();
        return posts;
    }

    //아이디로 게시물 조회
    @GetMapping("/posts/{id}")
    public Post findPostById(@PathVariable String userId){
        Post post=PostService.findPostById();
        return post;
    }

    //게시물 등록
    @PostMapping("/posts")
    public Post registerPost(@RequestBody PostBody postBody){
        Post post=PostService.savePost();
        return post;
    }

    //아이디와 게시물 번호로 게시물 업데이트
    @PutMapping("/posts/{id}/{post_num}")
    public Post updatedPost(@PathVariable String userId, int postNum, @RequestBody PostBody postBody) {
        Post post = PostService.updatePost();
        return post;
    }

    //아이디와 게시물 번호로 게시물 삭제
    @DeleteMapping("/posts/{id}/{post_num}")
    public Post deletedPost(@PathVariable String userId, int postNum, @RequestBody PostBody postBody){
        Post post = PostService.deletePost();
        return post;
    }
}
