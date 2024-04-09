package com.example.service;

import com.example.repository.repositories.UserRepository;
import com.example.security.JwtProvider;
import com.example.web.DTO.Login;
import com.example.web.DTO.SignUp;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final JwtProvider jwtProvider;
    
    public static String signup(SignUp signUp){
        return "회원가입이 완료되었습니다.";
    }

    public static String login(Login login) {
        return "로그인이 완료되었습니다.";
    }


    @Override
    public UserDetails loadUserByUsername(String userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new UsernameNotFoundException("사용자를 찾을 수 없습니다."));
    }
}
