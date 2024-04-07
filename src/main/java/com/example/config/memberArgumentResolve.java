package com.example.config;

import com.example.service.JwtService;
import com.example.web.dto.AuthInfo;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.util.Map;

public class memberArgumentResolve implements HandlerMethodArgumentResolver {

    private final JwtService jwtService;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return AuthInfo.class.isAssignableFrom(parameter.getParameterType());
    }

    @Override
    public Object resolveArgument(MethodParameter parameter,
                                  ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest,
                                  WebDataBinderFactory binderFactory) {
        String authorization = webRequest.getHeader("Authorization");
        if (authorization == null || !authorization.startsWith("Bearer")){
            throw new RuntimeException("UnauthorizedException");
        }
        String token = authorization.substring(7);
        Map<String Long> decodedToken = jwtService.decode(token);
        Long userId = decodedToken.get(jwtService.CLAIM_NAME_USER_ID);
        if (userId == null){
            throw new RuntimeException("UnauthorizedException");
        }
        return AuthInfo.of(userId);
    }
}
