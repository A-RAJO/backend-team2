package com.example.baFirstProjectTeam02.web.dto.comment;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CommentResult {
    private Integer userId;
    private Integer postNum;
    private String commentContents;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
