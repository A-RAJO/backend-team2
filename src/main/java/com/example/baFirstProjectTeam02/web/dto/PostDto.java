package com.example.baFirstProjectTeam02.web.dto;

import com.example.baFirstProjectTeam02.repository.users.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PostDto {
    private Integer postNum;
    private UserEntity userId;
    private String postTitle;
    private String postContents;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
