package com.example.baFirstProjectTeam02.web.dto.comment;


import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CommentDto {
    private Integer commentNum;
    private Integer postNum;
    private Integer userId;
    private String commentContents;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
