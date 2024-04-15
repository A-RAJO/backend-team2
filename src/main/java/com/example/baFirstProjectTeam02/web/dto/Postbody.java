package com.example.baFirstProjectTeam02.web.dto;

import com.example.baFirstProjectTeam02.repository.users.UserEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.context.annotation.Bean;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Postbody {
    @JsonProperty("user_id")
    private UserEntity userId;
    @JsonProperty("post_title")
    private String postTitle;
    @JsonProperty("post_contents")
    private String postContents;
}
