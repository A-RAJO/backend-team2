package com.example.service;

import com.example.repository.Entity.Posts;
import com.example.repository.repositories.JwtRepository;
import com.example.repository.repositories.PostRepository;
import com.example.repository.repositories.UserRepository;
import com.example.security.JwtProvider;
import com.example.web.DTO.PostBody;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final JwtProvider jwtProvider;
    public List<Posts> findAllPost() {
        List<Posts> posts= postRepository.findAll();
        return posts;
    }

    public static List<Posts> findPostById(String userId) {

    }

    public static Posts savePost(PostBody postBody) {


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
