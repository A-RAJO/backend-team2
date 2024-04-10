package com.example.baFirstProjectTeam02.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import java.io.IOException;

@RequiredArgsConstructor
public class JwtTokenFilter extends GenericFilterBean {

    private final JwtProvider jwtProvider;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // 헤더에서 토큰 받아오기
        String token = jwtProvider.resolveToken((HttpServletRequest) request);

        // 토큰이 유효하다면
        if (token != null && jwtProvider.validateToken(token)) {
            // 토큰으로부터 유저 정보를 받아
            Authentication authentication = jwtProvider.getAuthentication(token);
            // SecurityContext 에 객체 저장
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        // 다음 Filter 실행
        chain.doFilter(request, response);
    }
}