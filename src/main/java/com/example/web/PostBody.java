package com.example.web;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.sql.rowset.serial.SerialBlob;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostBody {
    private String title;
    private String contents;
    private SerialBlob image;
}
