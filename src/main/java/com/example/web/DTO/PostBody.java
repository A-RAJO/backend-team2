package com.example.web.DTO;

import lombok.*;

import javax.sql.rowset.serial.SerialBlob;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

//post request에 사용
public class PostBody {
    private String title;
    private String contents;
    private SerialBlob image;
}
