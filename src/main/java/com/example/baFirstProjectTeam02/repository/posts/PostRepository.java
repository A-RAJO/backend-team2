package com.example.baFirstProjectTeam02.repository.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Posts, Integer> {
    static Posts findByEmail(String email) {
    }

    static void deleteByPostNum(int postNum) {
    }

    Optional<Object> findByPostNum(int postNum);
}
