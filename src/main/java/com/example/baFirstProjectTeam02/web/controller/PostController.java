package com.example.baFirstProjectTeam02.web.controller;

import com.example.baFirstProjectTeam02.repository.posts.Posts;
import com.example.baFirstProjectTeam02.service.PostService;
import com.example.baFirstProjectTeam02.web.dto.PostDto;
import com.example.baFirstProjectTeam02.web.dto.Postbody;
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
    public List<PostDto> PostList(){
        List<PostDto> posts=postService.findAllPost();
        return posts;
    }

    //제목으로 게시물 조회
    @GetMapping("/posts/search")
    public List<PostDto> findPostByTitle(@RequestParam("title") String title){
        return postService.findByTitle(title);
    }

    //이메일로 게시물 조회
    @GetMapping("/posts/search")
    public List<PostDto> findPostByEmail(@RequestParam("email") String email){
        return postService.findByEmail(email);
    }

    //게시물 등록
    @PostMapping("/posts")
    public String registerPost(@RequestBody Postbody postbody){
        Integer postNum=postService.savePost(postbody);
        return postNum+"번 게시물이 등록되었습니다.";
    }

    //게시물 번호로 게시물 삭제
    @DeleteMapping("/posts/{post_num}")
    public String deletePostVyPostNum(@PathVariable int postNum){
        postService.deletePost(postNum);
        return postNum+"번 게시물이 삭제되었습니다.";
    }

    //게시물 번호로 게시물 수정
    @PutMapping("/posts/{post_num}")
    public PostDto updatePost(@PathVariable int postNum, @RequestBody Postbody postbody){
        return postService.updatePost(postNum,postbody);
    }
}
