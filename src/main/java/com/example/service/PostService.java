package com.example.service;

import com.example.repository.Entity.Post;
import com.example.web.PostBody;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    public static List<Post> findAllPost() {
    }

    public static List<Post> findPostById(String userId) {
        return null;
    }

    public static Post savePost(PostBody postBody) {
    }

    public static Post updatePost(String userId, int postNum) {
    }

    public static Post deletePost(int postNum) {
    }

    public static List<Post> findPostByTitle(String title) {
    }

    public static List<Post> findPostByTitleAndUserId(String title, String userId) {
    }
}
