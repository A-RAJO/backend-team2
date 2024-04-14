package com.example.baFirstProjectTeam02.web.dto;

import com.example.baFirstProjectTeam02.repository.posts.Posts;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostLikeRequest {
    private Posts posts;
    private LikeRequest likeRequest;
    private int like;
}