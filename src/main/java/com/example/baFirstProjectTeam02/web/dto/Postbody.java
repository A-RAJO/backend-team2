package com.example.baFirstProjectTeam02.web.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Blob;

@Getter
@NoArgsConstructor
public class Postbody {
    private int userId;
    private String postTitle;
    private String postContents;
//    private Blob image;
}
