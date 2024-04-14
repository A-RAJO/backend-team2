package com.example.baFirstProjectTeam02.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.context.annotation.Bean;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Postbody {
    @JsonProperty("post_title")
    private String postTitle;
    @JsonProperty("post_contents")
    private String postContents;
}
