package com.example.web.controler;

import com.example.service.UserService;
import com.example.web.dto.AuthInfo;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponse> writePost(
            AuthInfo authInfo,
            @RequestBody UserRequest userRequest
    ){
        User user = userService.userRequest.getBody(), authInfo.getUserId();
        return ResponseEntity.ok(UserResponse.from(User));
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllUser(AuthInfo authInfo){
        return ResponseEntity.ok(
                userService.getAllUser().stream()
                        .map(UserResponse::from)
                        .collect(Collectors.toList())
        );
    }
}



