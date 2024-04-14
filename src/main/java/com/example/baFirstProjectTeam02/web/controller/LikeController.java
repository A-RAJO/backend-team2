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

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/api/likes")
public class LikeController {
    private final LikeService likeService;

    @PostMapping("/like")
    public ResponseEntity<PostLikeRequest> addLike(@RequestBody LikeRequest likeRequest){
        PostLikeRequest result = likeService.addLike(likeRequest);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PostMapping("/unlike")
    public ResponseEntity<?> unlikePost(@RequestParam int userId, @RequestParam int postNum){
        return ResponseEntity.ok().build();
    }

    @PostMapping("/count")
    public ResponseEntity<?> getLikeCount(@RequestParam Posts postNum){
        return ResponseEntity.ok(likeService.getLikeCount(postNum));
    }
}