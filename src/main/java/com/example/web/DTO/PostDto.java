package com.example.web.DTO;

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
public class PostDto {
    private static int PostNum=1;
    private String userId;
    private String title;
    private String contents;
    private SerialBlob image;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
