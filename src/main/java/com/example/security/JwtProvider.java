package com.example.security;

import com.example.service.UserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
import lombok.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Base64;
import java.util.Date;
import java.util.List;


//로그인이 되면 1시간 만료 jwt 발급하기
//유효한 jwt 토큰이 있는지 체크
//검증된 JWT 토큰에서 사용자 정보 조회 및 가져오기

@Getter
@Component
@Builder
public class JwtProvider {

    private final long tokenValidTime = 1000L*60*60;
    private UserService userDetailsService;

    //yaml 파일의 secretkey 암호화
   @Value("${jwt.secret_key_source}")
        private String secretKeySource;
        private String secretKey;
    @PostConstruct
    public void setUp() {
        secretKey = Base64.getEncoder()
                .encodeToString(secretKeySource.getBytes());
    }

    //jwt토큰 발급하기

    public String createToken(String userId) {
        Claims claims = Jwts.claims()
                .setSubject(userId);
        Date now = new Date();
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + tokenValidTime))
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    // 인증 정보 조회
    //UserDetail=User
    @Bean
    public Authentication getAuthentication(String token) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(token);
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }


    // 토큰에서 회원 정보 추출
    @Bean
    public String getUserPk(String token) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
    }

    // 토큰 유효성, 만료일자 확인
    @Bean
    public boolean validateToken(String jwtToken) {
        try {
            Claims claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(jwtToken).getBody();
            return !claims.getExpiration().before(new Date());
        } catch (Exception e) {
            return false;
        }
    }

    // Request의 Header에서 token 값 가져오기
    @Bean
    public String resolveToken(HttpServletRequest request) {
        return request.getHeader("X-AUTH-TOKEN");
    }

}
