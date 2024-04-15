package com.example.baFirstProjectTeam02.web.controller;

import com.example.baFirstProjectTeam02.repository.posts.Posts;
import com.example.baFirstProjectTeam02.service.LikeService;
import com.example.baFirstProjectTeam02.web.dto.LikeRequest;
import com.example.baFirstProjectTeam02.web.dto.PostLikeRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/api/likes")
public class LikeController {
    private final LikeService likeService;

    @PostMapping("/like")
    public ResponseEntity<PostLikeRequest> addLike(@RequestBody LikeRequest likeRequest){
        PostLikeRequest result = likeService.addLike(likeRequest);
        String responseMessage = "게시물에 좋아요를 추가했습니다. 현재 좋아요 수: " + result.getLike();
        return ResponseEntity.ok()
                .header("Message", responseMessage)
                .body(result);
    }

    @PostMapping("/unlike")
    public ResponseEntity<String> unlikePost(@RequestParam int userId, @RequestParam int postNum){
        String responseMessage = likeService.unlikePost(userId, postNum);
        return ResponseEntity.ok()
                .header("Message", responseMessage)
                .body(responseMessage);
    }

    @PostMapping("/count")
    public ResponseEntity<Integer> getLikeCount(@RequestParam Posts postNum){
        int likeCount = likeService.getLikeCount(postNum);
        return ResponseEntity.ok(likeCount);
    }
}