package com.example.baFirstProjectTeam02.repository.posts;

import com.example.baFirstProjectTeam02.web.dto.PostDto;
import com.example.baFirstProjectTeam02.web.dto.Postbody;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Posts, Integer> {

    static void deletePost(int postNum) {
    }
    Posts findByPostNum(int postNum);

    List<Posts> findByPostTitle(String title);


}
