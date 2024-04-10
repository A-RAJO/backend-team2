package com.example.baFirstProjectTeam02.repository;

import com.example.baFirstProjectTeam02.repository.Entity.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Posts,Integer> {
    List<Posts> findAllById(String userId);
}
