package com.example.baFirstProjectTeam02.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Blob;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Postbody {
    private Integer userId;
    private String postTitle;
    private String postContents;
//    private Blob image;
}
