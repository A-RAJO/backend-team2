package com.example.security;

import com.example.service.UserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.http.HttpServletRequest;
import lombok.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Base64;
import java.util.Date;


//로그인이 되면 1시간 만료 jwt 발급하기
//유효한 jwt 토큰이 있는지 체크
//검증된 JWT 토큰에서 사용자 정보 조회 및 가져오기

@Getter
@Component
@RequiredArgsConstructor
@Builder
public class JwtProvider {

    private String secretKey;
    private UserService userDetailsService;

    //yaml 파일의 secretkey 암호화
    public String encoding(@Value("${jwt.secret_key_source}") String secretKey) {
        return this.secretKey=Base64.getEncoder().encodeToString(secretKey.getBytes());
    }
    //토큰 유효기간
    private long tokenValidTime = 1000L*60*60;

    //jwt토큰 발급하기
    private JwtTokenDto RegisterToken(Authentication authentication){

        Date now = new Date();

        String jwt = Jwts.builder()
                .setSubject(String.valueOf(authentication))
                .setIssuedAt(now)
                .claim("auth", authentication)
                .setExpiration(new Date(now.getTime() + tokenValidTime))
                .signWith(SignatureAlgorithm.HS256,secretKey)
                .compact();

        return new JwtTokenDto("Bearer", jwt);
    }

    // 인증 정보 조회
    //UserDetail=User
    public Authentication getAuthentication(String token) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(this.getUserPk(token));
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }


    // 토큰에서 회원 정보 추출
    public String getUserPk(String token) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
    }

    // 토큰 유효성, 만료일자 확인
    public boolean validateToken(String jwtToken) {
        try {
            Claims claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(jwtToken).getBody();
            return !claims.getExpiration().before(new Date());
        } catch (Exception e) {
            return false;
        }
    }

    // Request의 Header에서 token 값 가져오기
    public String resolveToken(HttpServletRequest request) {
        return request.getHeader("X-AUTH-TOKEN");
    }

}
