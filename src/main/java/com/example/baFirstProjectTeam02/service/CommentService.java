    package com.example.baFirstProjectTeam02.service;

    import com.example.baFirstProjectTeam02.repository.Mapper.CommentMapper;
    import com.example.baFirstProjectTeam02.repository.comment.CommentRepository;
    import com.example.baFirstProjectTeam02.repository.comment.CommentEntity;
    import com.example.baFirstProjectTeam02.service.exceptions.NotFoundException;
    import com.example.baFirstProjectTeam02.web.dto.comment.CommentRequest;
    import com.example.baFirstProjectTeam02.web.dto.comment.CommentResult;
    import lombok.RequiredArgsConstructor;
    import org.springframework.stereotype.Service;

    import java.time.LocalDateTime;

    @Service
    @RequiredArgsConstructor
    public class CommentService {

        private final CommentRepository commentRepository;

        public CommentResult addComment(CommentRequest commentRequest) {
            CommentEntity commentEntity = CommentMapper.INSTANCE.commentRequestToCommentEntity(commentRequest);

            commentEntity.setCreatedAt(LocalDateTime.now()); // 현재 시간으로 설정
            commentEntity.setUpdatedAt(LocalDateTime.now()); // 현재 시간으로 설정
            commentRepository.save(commentEntity);

            return CommentMapper.INSTANCE.commentEntityToCommentResult(commentEntity);
        }

        public CommentResult updateComment(Integer commentNum, CommentRequest commentRequest) {
            CommentEntity commentEntityUpdated = commentRepository.findById(commentNum)
                    .orElseThrow(() -> new NotFoundException("해당 ID: " + commentNum + "의 comment을 찾을 수 없습니다."));

            commentEntityUpdated.setCommentContents(commentRequest.getCommentContents());
            commentEntityUpdated.setUpdatedAt(LocalDateTime.now());

            commentRepository.save(commentEntityUpdated);

            return CommentMapper.INSTANCE.commentEntityToCommentResult(commentEntityUpdated);
        }

        public void deleteComment(Integer commentNum) {
            commentRepository.deleteById(commentNum);
        }
    }
