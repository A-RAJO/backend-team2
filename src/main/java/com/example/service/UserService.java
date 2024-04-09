package com.example.service;

import com.example.repository.repositories.UserRepository;
import com.example.security.JwtProvider;
import com.example.security.JwtTokenDto;
import com.example.web.DTO.Login;
import com.example.web.DTO.SignUp;
import jakarta.transaction.Transactional;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
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

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final JwtProvider jwtProvider;
    private final JwtTokenDto jwtTokenDto;

    @Transactional
    public String signup(SignUp signUp){
        if (userRepository.existsByUserId(signUp.getUserId())) {
            throw new RuntimeException("이미 가입되어 있는 유저입니다");
        }
        Timestamp now=new Timestamp(System.currentTimeMillis());
        com.example.repository.Entity.User user= com.example.repository.Entity.User.builder()
                .userId(signUp.getUserId())
                .passWord(passwordEncoder.encode(signUp.getPassword()))
                .userName(signUp.getUserName())
                .phone(signUp.getPhone())
                .createdAt(now)
                .build();

        return "회원가입이 완료되었습니다.";
    }



    @Transactional
    public JwtTokenDto login(Login login) {
        UsernamePasswordAuthenticationToken authenticationToken = JwtProvider.RegisterToken(jwtProvider.getAuthentication(login));

        return "로그인이 완료되었습니다.";
    }

    public TokenDto login(MemberRequestDto memberRequestDto) {
        // 1. Login ID/PW 를 기반으로 AuthenticationToken 생성
        UsernamePasswordAuthenticationToken authenticationToken = memberRequestDto.toAuthentication();

        // 2. 실제로 검증 (사용자 비밀번호 체크) 이 이루어지는 부분
        //    authenticate 메서드가 실행이 될 때 CustomUserDetailsService 에서 만들었던 loadUserByUsername 메서드가 실행됨
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);

        // 3. 인증 정보를 기반으로 JWT 토큰 생성
        TokenDto tokenDto = tokenProvider.generateTokenDto(authentication);

        // 4. RefreshToken 저장
        RefreshToken refreshToken = RefreshToken.builder()
                .key(authentication.getName())
                .value(tokenDto.getRefreshToken())
                .build();

        refreshTokenRepository.save(refreshToken);

        // 5. 토큰 발급
        return tokenDto;
    }
    @Override
    public UserDetails loadUserByUsername(String userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new UsernameNotFoundException("사용자를 찾을 수 없습니다."));
    }
}
