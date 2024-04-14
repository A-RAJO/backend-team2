package com.example.baFirstProjectTeam02.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Postbody {
    private Integer postNum;
    private Integer userId;
    private String postTitle;
    private String postContents;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
