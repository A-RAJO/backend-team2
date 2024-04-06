package com.example.web;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.sql.rowset.serial.SerialBlob;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class PostDTO {
    static int postNum;
    private String userId;
    private String title;
    private String contents;
    private SerialBlob image;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
