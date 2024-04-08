package com.example.repository.repositories;

import com.example.repository.Entity.Users.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,String> {

   Optional<String> userId(String userId);

}