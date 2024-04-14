package com.example.baFirstProjectTeam02.service;

import com.example.baFirstProjectTeam02.repository.likes.Like;
import com.example.baFirstProjectTeam02.repository.likes.LikeRepository;
import com.example.baFirstProjectTeam02.repository.posts.PostRepository;
import com.example.baFirstProjectTeam02.repository.posts.Posts;
import com.example.baFirstProjectTeam02.repository.users.UserEntity;
import com.example.baFirstProjectTeam02.repository.users.UserRepository;
import com.example.baFirstProjectTeam02.service.exceptions.NotFoundException;
import com.example.baFirstProjectTeam02.web.dto.LikeRequest;
import com.example.baFirstProjectTeam02.web.dto.PostLikeRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;

@Slf4j
@Service
public class LikeService {
    private final PostRepository postRepository;
    private final LikeRepository likeRepository;
    private final UserRepository userRepository;

    @Autowired
    public LikeService(PostRepository postRepository, LikeRepository likeRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.likeRepository = likeRepository;
        this.userRepository = userRepository;
    }

/*    public void addLike(int postNum, UserEntity user){
        Posts posts = PostService.(postNum);
        if(!likeRepository.existsByUserIdAndPostNum(user, posts)){
            posts.setLike(posts.getLike()+1);
            likeRepository.save(new Like(user, posts));
        }
        else {
            posts.setLike(posts.getLike()-1);
            likeRepository.deleteByUserIdAndPostNum(user, posts);
        }
    }*/

    @Transactional
    public PostLikeRequest addLike(LikeRequest likeRequest){
        System.out.println(userRepository.findById(likeRequest.getPostNum()));
        Optional<UserEntity> optionalUserEntity = userRepository.findById(likeRequest.getUserId());
        optionalUserEntity.orElseThrow(() -> new NotFoundException("유저를 찾을 수 없습니다."));
        Optional<Posts> optionalPosts = postRepository.findById(likeRequest.getPostNum());
        Posts posts = optionalPosts.orElseThrow(() -> new NotFoundException("게시물을 찾을 수 없습니다."));
        Like like = Like.builder()
                .userId(optionalUserEntity.get().getUserId())
                .postNum(optionalPosts.get().getPostNum())
                .build();
        likeRepository.save(like);

        int likeCount = likeRepository.countByPostNum(like.getPostNum());
        PostLikeRequest postLikeRequest = PostLikeRequest.builder()
                .posts(posts)
                .likeRequest(likeRequest)
                .like(likeCount)
                .build();
        return postLikeRequest;
    }
    public void unlikePost(int userId, int postNum) throws IOException {
        Optional<Like> likeOpt = likeRepository.findByUserIdAndPostNum(userId, postNum);
        if (!likeOpt.isPresent()){
            throw new IOException("좋아요 정보를 찾을 수 없습니다.");
        }
        likeRepository.delete(likeOpt.get());
    }
    public int getLikeCount(Posts postNum){
        return likeRepository.countByPostNum(postNum.getPostNum());
    }
}
