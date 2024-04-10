package com.example.baFirstProjectTeam02.repository;

import com.example.baFirstProjectTeam02.repository.Entity.User;
import com.example.baFirstProjectTeam02.web.DTO.SignUp;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,String> {
    Optional<User> findByUserId(String UserId);
    boolean existsByUserId(String UserId);

}
