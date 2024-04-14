package com.example.baFirstProjectTeam02.repository.likes;

import com.example.baFirstProjectTeam02.repository.posts.Posts;
import com.example.baFirstProjectTeam02.repository.users.UserEntity;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LikeRepository extends JpaRepository<Like, Integer> {

    Optional<Like> findByUserIdAndPostNum(int userId, int postNum);

    //있는지 없는지 검토
    boolean existsByUserIdAndPostNum(int userId, int postNum);

    //삭제
    void deleteByUserIdAndPostNum(int userId, int postNum);

    int countByPostNum(int postNum);

    Optional<Like> findByUserId(int userId);

    @Query("SELECT l FROM Like l WHERE l.userId = :userId AND l.postNum = :postNum")
    Optional<Like> findByUserIdAndPostNum(@Param("userId") Integer userId, @Param("postNum") int postNum);
}