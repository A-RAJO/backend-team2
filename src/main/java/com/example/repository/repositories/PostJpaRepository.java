package com.example.repository.repositories;

import com.example.repository.Entity.Posts.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostJpaRepository extends JpaRepository<Posts,Integer> {
    List<Posts> findAllById(String userId);
}
