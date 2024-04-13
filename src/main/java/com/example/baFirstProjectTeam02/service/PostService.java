package com.example.baFirstProjectTeam02.service;

import com.example.baFirstProjectTeam02.repository.Mapper.PostMapper;
import com.example.baFirstProjectTeam02.repository.posts.PostRepository;
import com.example.baFirstProjectTeam02.repository.posts.Posts;
import com.example.baFirstProjectTeam02.service.exceptions.NotAcceptException;
import com.example.baFirstProjectTeam02.service.exceptions.NotFoundException;
import com.example.baFirstProjectTeam02.web.dto.PostDto;
import com.example.baFirstProjectTeam02.web.dto.Postbody;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Slf4j
@Service
public class PostService {

    private final PostRepository postRepository;

    public List<PostDto> findAllPost() {
        List<Posts> postEntity=postRepository.findAll();
        if(postEntity.isEmpty()) throw new NotFoundException("등록된 게시물이 없습니다.");
        return postEntity.stream().map(PostMapper.INSTANCE::postEntityToPostDto).collect(Collectors.toList());
    }

    public List<PostDto> findByTitle(String title) {
        List<Posts> postEntity=postRepository.findByPostTitle(title);
        return postEntity.stream().map(PostMapper.INSTANCE::postEntityToPostDto).collect(Collectors.toList());
    }

    public void deletePost(int postNum) {
        PostRepository.deletePost(postNum);
    }

    public Integer savePost(Postbody postbody) {
        Posts postEntity=PostMapper.INSTANCE.emailAndPostbodyToPostEntity(null,postbody);
        Posts postEntityCreated;
        try {
            postEntityCreated = postRepository.save(postEntity);
        } catch (RuntimeException exception){
            throw new NotAcceptException("Post을 저장하는 도중에 Error 가 발생하였습니다.");
        }
        return postEntityCreated.getPostNum();
    }

    @Transactional
    public PostDto updatePost(int postNum, Postbody postbody) {
        Posts postEntityUpdated= postRepository.findByPostNum(postNum);
                //.orElseThrow(() -> new NotFoundException("해당 ID: " + postNum + "의 Item을 찾을 수 없습니다."));
        postEntityUpdated.setPostBody(postbody);
        return PostMapper.INSTANCE.postEntityToPostDto(postEntityUpdated);
    }
}
