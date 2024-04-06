package com.example.repository;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.sql.rowset.serial.SerialBlob;
import java.sql.Timestamp;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "post_num", nullable = false)
    static int postNum;
    private String userId;
    private String title;
    private String contents;
    private SerialBlob image;
    private Timestamp createdAt;
    private Timestamp updatedAt;

}
