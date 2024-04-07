package com.example.service;

import com.example.repository.Entity.Post;
import com.example.repository.PostJpaRepository;
import com.example.web.PostBody;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

    private static PostJpaRepository postJpaRepository;
    public static List<Post> findAllPost() {
        List<Post> posts=postJpaRepository.findAll();
        return posts;
    }

    public static List<Post> findPostById(String userId) {
        List<Post> posts=postJpaRepository.findAllById(userId);
        return posts;
    }

    public static Post savePost(PostBody postBody) {
        Post post=postJpaRepository
    }

    public static Post updatePost(int userId, PostBody postNum) {
    }

    public static Post deletePost(int postNum) {
    }

    public static List<Post> findPostByTitle(String title) {
    }

    public static List<Post> findPostByTitleAndUserId(String title, String userId) {
    }
}
