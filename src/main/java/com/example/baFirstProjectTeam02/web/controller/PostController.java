package com.example.baFirstProjectTeam02.web.controller;

import com.example.baFirstProjectTeam02.service.PostService;
import com.example.baFirstProjectTeam02.web.dto.PostDto;
import com.example.baFirstProjectTeam02.web.dto.Postbody;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;
    //모든 게시판 조회
    @GetMapping("/list")
    public List<PostDto> PostList(){
        return postService.findAllPost();
    }

    //제목으로 게시물 조회
    @GetMapping("/search")
    public List<PostDto> findPostByTitle(@RequestParam("title") String title){
        return postService.findByTitle(title);
    }


    //게시물 등록
    @PostMapping("/register")
    public String registerPost(@RequestBody Postbody postbody){
        postService.savePost(postbody);
        return "게시물이 등록되었습니다.";
    }

    //게시물 번호로 게시물 삭제
    @DeleteMapping("/{post_num}")
    public String deletePostByPostNum(@PathVariable int postNum){
        postService.deletePost(postNum);
        return postNum+"번 게시물이 삭제되었습니다.";
    }

    //게시물 번호로 게시물 수정
    @PutMapping("/{post_num}")
    public PostDto updatePost(@PathVariable int postNum, @RequestBody Postbody postbody){
        return postService.updatePost(postNum,postbody);
    }
}
