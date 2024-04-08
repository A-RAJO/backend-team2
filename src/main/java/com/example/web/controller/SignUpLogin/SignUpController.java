package com.example.web.controller.SignUpLogin;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/v1/api/sign")
public class SignUpController {

    private final AuthService authService;

    @PostMapping(value = "/register")
    public String register(@RequestBody SignUpDto signUpRequest){
        boolean isSuccess=authService.signUp(signUpRequest);
        return isSuccess?"회원가입에 성공하였습니다.":"회원가입에 실패하였습니다.";
    }
}
