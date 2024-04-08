package com.example.web.controller;

import com.example.repository.Entity.Posts;
import com.example.repository.Entity.User;
import com.example.service.PostService;
import com.example.service.UserService;
import com.example.web.DTO.PostBody;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api")
public class PostController {

    private final PostService postService;
    private final UserService userService;

    //모든 게시물 조회
    @GetMapping("/posts")
    public List<Posts> findAllPost(){
        List<Posts> posts=postService.findAllPost();
        return posts;
    }

    //아이디로 게시물 조회
    @GetMapping("/posts/search/{id}")
    public List<Posts> findPostById(@PathVariable String userId){
        List<Posts> posts=postService.findPostById(userId);
        return posts;
    }

    //제목으로 게시물 조회
    @GetMapping("/posts/search")
    public List<Posts> findPostByTitle(@RequestParam String title){
        List<Posts> posts=postService.findPostByTitle(title);
        return posts;
    }

    //아이디+제목으로 게시물 조회
    @GetMapping("/posts/searches")
    public List<Posts> findPostByTitleAndUserId(@RequestParam String title, String userId){
        List<Posts> posts=postService.findPostByTitleAndUserId(title,userId);
        return posts;
    }

    //게시물 등록(로그인 후 이용가능)
    @PostMapping("/posts")
    public Posts registerPost(@RequestBody PostBody postBody){
        Posts posts = postService.savePost(postBody);
        return posts;
    }

    //게시물 번호로 게시물 업데이트(로그인 후 이용가능)
    @PutMapping("/posts")
    public Posts updatedPost(@RequestParam int postNum, @RequestBody PostBody postBody) {
        Posts posts = postService.updatePost(postNum,postBody);
        return posts;
    }

    //게시물 번호로 게시물 삭제(로그인 후 이용가능)
    @DeleteMapping("/posts/{post_num}")
    public String deletedPost(@PathVariable int postNum){
        postService.deletePost(postNum);
        return postNum+"번 게시물이 성공적으로 삭제되었습니다.";
    }
}
