package com.example.baFirstProjectTeam02.security;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@AllArgsConstructor
public class token {
    String grantType;
    String accessToken;
}
