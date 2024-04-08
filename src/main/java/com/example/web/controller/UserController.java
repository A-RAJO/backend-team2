package com.example.web.controller;

import com.example.service.UserService;
import com.example.web.DTO.Login;
import com.example.web.DTO.SignUp;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {

    private final UserService userService;
    @PostMapping("/signup")
    public ResponseEntity<Integer> signup(@RequestBody SignUp signUp) {
        userService.signup(signUp);
        return ResponseEntity.ok (HttpStatus.OK.value());
    }

    @PostMapping("/login")
    public ResponseEntity<Integer> login(@RequestBody Login login) {
        userService.login(login);
        return ResponseEntity.ok (HttpStatus.OK.value());
    }

}



