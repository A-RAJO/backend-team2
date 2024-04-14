package com.example.baFirstProjectTeam02.repository.comment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Integer> {
    // 사용자가 작성한 댓글 목록을 가져오는 쿼리
    @Query("SELECT c FROM CommentEntity c WHERE c.userId = :userId")
    List<CommentEntity> findByUserId(Integer userId);

    // 특정 게시물에 작성된 댓글 목록을 가져오는 쿼리
    @Query("SELECT c FROM CommentEntity c WHERE c.postNum = :postNum")
    List<CommentEntity> findByPostNum(Integer postNum);
}
