package com.example.service;

import com.example.repository.repositories.UserRepository;
import com.example.web.DTO.Login;
import com.example.web.DTO.SignUp;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public static String signup(SignUp signUp){
        return "회원가입이 완료되었습니다.";
    }

    public static String login(Login login) {
        return "로그인이 완료되었습니다.";
    }
}
