package com.example.baFirstProjectTeam02.service;

import com.example.baFirstProjectTeam02.web.DTO.PostBody;
import com.example.baFirstProjectTeam02.repository.Entity.Posts;
import com.example.baFirstProjectTeam02.repository.PostRepository;
import com.example.baFirstProjectTeam02.repository.UserRepository;
import com.example.baFirstProjectTeam02.security.JwtProvider;
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
        return null;
    }

    public static Posts savePost(PostBody postBody) {
        return null;

    }

    public static Posts updatePost(int userId, Posts postNum) {
        return null;

    }

    public static Posts deletePost(int postNum) {
        return null;
    }

    public static List<Posts> findPostByTitle(String title) {
        return null;

    }

    public static List<Posts> findPostByTitleAndUserId(String title, String userId) {
        return null;

    }
}
