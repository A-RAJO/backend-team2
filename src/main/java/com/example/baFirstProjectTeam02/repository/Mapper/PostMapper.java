package com.example.baFirstProjectTeam02.repository.Mapper;

import com.example.baFirstProjectTeam02.repository.posts.Posts;
import com.example.baFirstProjectTeam02.web.dto.PostDto;
import com.example.baFirstProjectTeam02.web.dto.Postbody;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PostMapper {
    PostMapper INSTANCE= Mappers.getMapper(PostMapper.class);

    // 메소드
    PostDto postEntityToPostDto(Posts postEntity);
    Posts postbodyToPostEntity(Postbody postBody);
}
