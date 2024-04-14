package com.example.baFirstProjectTeam02.repository.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Posts, Integer> {

    Posts findByPostNum(int postNum);
    List<Posts> findByPostTitle(String title);
    void deleteByPostNum(int postNum);
}
