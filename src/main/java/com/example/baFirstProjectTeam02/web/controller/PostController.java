package com.example.baFirstProjectTeam02.web.controller;

import com.example.baFirstProjectTeam02.repository.Post;
import com.example.baFirstProjectTeam02.repository.posts.PostEntity;
import com.example.baFirstProjectTeam02.service.PostService;
import com.example.baFirstProjectTeam02.web.dto.Postbody;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api")
@RequiredArgsConstructor
@Slf4j
public class PostController {
    private final PostService postService;


    //모든 게시판 조회
    @GetMapping("/posts")
    public List<PostEntity> PostList(){
        List<PostEntity> posts=postService.findAllPost();
        return posts;
    }

    //제목으로 게시물 조회
    @GetMapping("/posts/search")
    public PostEntity findPostByTitle(@RequestParam("title") String title){
        PostEntity post=PostService.findPostByTitle(title);
        return post;
    }

    //이메일로 게시물 조회
    @GetMapping("/posts/search")
    public PostEntity findPostByEmail(@RequestParam("email") String email){
        PostEntity post=PostService.findPostByEmail(email);
        return post;
    }

    //게시물 등록
    @PostMapping("/posts")
    public String registerPost(@RequestBody Postbody postbody){
        Integer postNum=postService.savePost(postbody);
        return postNum+"번 게시물이 등록되었습니다.";
    }

    //게시물 번호로 게시물 삭제
    @DeleteMapping("/posts/{post_num}")
    public String deletePostVyPostNum(@PathVariable String postNum){
        postService.deletePost(postNum);
        return postNum+"번 게시물이 삭제되었습니다.";
    }

    //게시물 번호로 게시물 수정
    @PutMapping("/posts/{post_num}")
    public PostEntity updatePost(@PathVariable String postNum, @RequestBody Postbody postbody){
        PostEntity updatePost=postService.updatePost(postNum,postbody);
        return updatePost;
    }
}
