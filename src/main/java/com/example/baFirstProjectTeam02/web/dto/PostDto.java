package com.example.baFirstProjectTeam02.web.dto;

import com.example.baFirstProjectTeam02.repository.posts.PostImage;

import java.sql.Timestamp;

public class PostDto {
    private int post_num;
    private int userId;
    private String postTitle;
    private String post_contents;
    private PostImage image;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
