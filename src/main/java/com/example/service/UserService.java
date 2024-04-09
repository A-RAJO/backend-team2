package com.example.service;

import com.example.repository.repositories.UserRepository;
import com.example.security.JwtProvider;
import com.example.web.DTO.Login;
import com.example.web.DTO.SignUp;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

import static org.springframework.security.core.userdetails.User.builder;

@RequiredArgsConstructor
@ToString
@Service
public class UserService implements UserDetailsService {

    private static PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final JwtProvider jwtProvider;

    public static String signup(SignUp signUp){
        Timestamp now=new Timestamp(System.currentTimeMillis());
        com.example.repository.Entity.User user= com.example.repository.Entity.User.builder()
                .userId(signUp.getUserId())
                .passWord(passwordEncoder.encode(signUp.getPassword()))
                .userName(signUp.getUserName())
                .phone(signUp.getPhone())
                .createAt(now)
                .build();
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
