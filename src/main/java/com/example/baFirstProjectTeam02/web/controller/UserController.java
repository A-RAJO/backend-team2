package com.example.baFirstProjectTeam02.web.controller;

import com.example.baFirstProjectTeam02.service.UserService;
import com.example.baFirstProjectTeam02.web.DTO.UserDto;
import com.example.baFirstProjectTeam02.web.Exception.NotAcceptException;
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
    public ResponseEntity<Integer> signup(@RequestBody UserDto userDto) {
        userService.signup(userDto);
        return ResponseEntity.ok (HttpStatus.OK.value());
    }

    @PostMapping("/login")
    public ResponseEntity<Integer> login(@RequestBody UserDto login) throws NotAcceptException {
        userService.login(login);
        return ResponseEntity.ok (HttpStatus.OK.value());
    }

}



