package com.example.web.DTO;

import lombok.*;

import javax.sql.rowset.serial.SerialBlob;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class PostRequest {
    private static int PostNum=1;
    private String userId;
    private String title;
    private String contents;
    private SerialBlob image;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
