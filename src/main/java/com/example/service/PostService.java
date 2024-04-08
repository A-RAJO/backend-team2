package com.example.service;

import com.example.repository.Entity.Posts.Posts;
import com.example.repository.repositories.PostJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    private static PostJpaRepository postJpaRepository;
    public static List<Posts> findAllPost() {
        List<Posts> posts=postJpaRepository.findAll();
        return posts;
    }

    public static List<Posts> findPostById(String userId) {
        List<Posts> posts=postJpaRepository.findAllById(userId);
        return posts;
    }

    public static Posts savePost(PostBody postBody) {
        Posts posts =postJpaRepository
    }

    public static Posts updatePost(int userId, Posts postNum) {
    }

    public static Posts deletePost(int postNum) {
    }

    public static List<Posts> findPostByTitle(String title) {
    }

    public static List<Posts> findPostByTitleAndUserId(String title, String userId) {
    }
}
