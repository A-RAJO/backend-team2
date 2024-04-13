package com.example.baFirstProjectTeam02.web.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Blob;

@Getter
@NoArgsConstructor
public class Postbody {
    private int userId;
    private String postTitle;
    private String post_contents;
    private Blob image;
}
