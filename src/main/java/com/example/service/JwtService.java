package com.example.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Map;

@Slf4j
@Service
public class JwtService {
    private String secretKey;

    public static final String CLAIM_NAME_MEMBER_ID = "MemberId";
    private Algorithm algorithm;
    private JWTVerifier jwtVerifier;

    private void init(){
        algorithm = algorithm.HMAC256(secretKey);
        jwtVerifier = JWT.require(algorithm).build();
    }

    public String encode(Long userId){
        LocalDateTime expiredAt = LocalDateTime.now().plusWeeks(4L);
        Date date = Timestamp.valueOf(expiredAt);

        return JWT.create()
                .withClaim(CLAIM_NAME_MEMBER_ID, userId)
                .withExpiresAt(date)
                .sign(algorithm);
    }

    public Map<String, String> decode(String token){
        try {
            DecodeJWT jwt = jwtVerifier.verify(token);
            return Map.of(CLAIM_NAME_MEMBER_ID, jwt.getClaim(CLAIM_NAME_MEMBER_ID).asString);
        } catch (JWTVerificationException e){
            log.warn("Failed to decode jwt. token: {}", token, e);
            return null;
        }
    }
}
