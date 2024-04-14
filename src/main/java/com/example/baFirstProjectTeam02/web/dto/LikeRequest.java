package com.example.baFirstProjectTeam02.web.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class LikeRequest {
    private int postNum;
    private int userId;
}