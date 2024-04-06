package com.example.web.controller;

import com.example.repository.Entity.Post;
import com.example.service.PostService;
import com.example.web.PostBody;
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
    @GetMapping("/posts/search/{id}")
    public List<Post> findPostById(@PathVariable String userId){
        List<Post> posts=PostService.findPostById(userId);
        return posts;
    }

    //제목으로 게시물 조회
    @GetMapping("/posts/search")
    public List<Post> findPostByTitle(@RequestParam String title){
        List<Post> posts=PostService.findPostByTitle(title);
        return posts;
    }

    //아이디+제목으로 게시물 조회
    @GetMapping("/posts/searches")
    public List<Post> findPostByTitleAndUserId(@RequestParam String title, String userId){
        List<Post> posts=PostService.findPostByTitleAndUserId(title,userId);
        return posts;
    }

    //게시물 등록
    @PostMapping("/posts")
    public Post registerPost(@RequestBody PostBody postBody){
        Post post=PostService.savePost(postBody);
        return post;
    }

    //게시물 번호로 게시물 업데이트
    @PutMapping("/posts")
    public Post updatedPost(@RequestParam String userId, @RequestParam int postNum, @RequestBody PostBody postBody) {
        Post post = PostService.updatePost(userId, postNum);
        return post;
    }

    //게시물 번호로 게시물 삭제
    @DeleteMapping("/posts/{post_num}")
    public String deletedPost(@PathVariable int postNum){
        PostService.deletePost(postNum);
        return postNum+"번 게시물이 성공적으로 삭제되었습니다.";
    }
}
