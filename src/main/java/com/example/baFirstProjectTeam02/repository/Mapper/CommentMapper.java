package com.example.baFirstProjectTeam02.repository.Mapper;

import com.example.baFirstProjectTeam02.repository.comment.CommentEntity;
import com.example.baFirstProjectTeam02.repository.posts.Posts;
import com.example.baFirstProjectTeam02.repository.users.UserEntity;
import com.example.baFirstProjectTeam02.web.dto.comment.CommentRequest;
import com.example.baFirstProjectTeam02.web.dto.comment.CommentResult;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CommentMapper {
    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);

    @Mapping(target = "createdAt", source = "commentEntity.createdAt")
    @Mapping(target = "updatedAt", source = "commentEntity.updatedAt")
    @Mapping(target = "userId", source = "commentEntity.userId.userId")
    @Mapping(target = "postNum", source = "commentEntity.postNum.postNum")
    @Mapping(target = "commentContents", source = "commentEntity.commentContents")
    CommentResult commentEntityToCommentResult(CommentEntity commentEntity);

    default CommentEntity commentRequestToCommentEntity(CommentRequest commentRequest) {
        CommentEntity commentEntity = new CommentEntity();

        UserEntity userEntity = new UserEntity();
        userEntity.setUserId(commentRequest.getUserId());
        commentEntity.setUserId(userEntity);

        Posts postEntity = new Posts();
        postEntity.setPostNum(commentRequest.getPostNum());
        commentEntity.setPostNum(postEntity);

        commentEntity.setCommentContents(commentRequest.getCommentContents());

        return commentEntity;
    }
}
