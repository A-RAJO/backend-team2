package com.example.repository;

import com.example.repository.Entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostJpaRepository extends JpaRepository<Post,Integer> {
    List<Post> findAllById(String userId);
}
