package com.example.web;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.sql.rowset.serial.SerialBlob;
import java.sql.Timestamp;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PostBody {
    private String userId;
    private String title;
    private String contents;
    private SerialBlob image;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}