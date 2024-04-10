package com.example.baFirstProjectTeam02.service;

import com.example.baFirstProjectTeam02.web.DTO.UserDto;
import com.example.baFirstProjectTeam02.repository.Entity.User;
import com.example.baFirstProjectTeam02.repository.UserRepository;
import com.example.baFirstProjectTeam02.security.JwtProvider;
import com.example.baFirstProjectTeam02.web.Exception.NotAcceptException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@RequiredArgsConstructor
@ToString
@Service
public class UserService implements UserDetailsService {


    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final JwtProvider jwtProvider;


    @Transactional
    public String signup(UserDto userDto){
        if (userRepository.existsByUserId(userDto.getUserId())) {
            throw new RuntimeException("이미 가입되어 있는 유저입니다");
        }
        Timestamp now=new Timestamp(System.currentTimeMillis());
        User user= User.builder()
                .userId(userDto.getUserId())
                .passWord(passwordEncoder.encode(userDto.getPassword()))
                .userName(userDto.getUserName())
                .phone(userDto.getPhone())
                .createdAt(now)
                .build();

        return "회원가입이 완료되었습니다.";
    }
    @Transactional
    public String login(UserDto login) throws NotAcceptException {
        String userId=login.getUserId();
        String password=login.getPassword();

        try {
            Authentication authentication= jwtProvider.getAuthentication(
                    String.valueOf(new UsernamePasswordAuthenticationToken(userId,password))
            );

            SecurityContextHolder.getContext().setAuthentication(authentication);

            User user = userRepository.findByUserId(userId)
                    .orElseThrow(() -> new NotFoundException());

            return jwtProvider.createToken(userId)+"로그인 성공하였습니다.";

        } catch (Exception e){
            e.printStackTrace();
            throw new NotAcceptException("login failure");
        }
    }

    @Override
    public UserDetails loadUserByUsername(String userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new UsernameNotFoundException("사용자를 찾을 수 없습니다."));
    }


}
