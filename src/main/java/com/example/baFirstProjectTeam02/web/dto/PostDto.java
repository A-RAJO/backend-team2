package com.example.baFirstProjectTeam02.web.dto;

import com.example.baFirstProjectTeam02.repository.posts.PostImage;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PostDto {
    private Integer postNum;
    private Integer userId;
    private String postTitle;
    private String postContents;
//    private PostImage image;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
