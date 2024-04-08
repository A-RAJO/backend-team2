package com.example.repository.Entity.Posts;

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
public class Posts {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "post_num", nullable = false)
    static int postNum;

    @Column(name = "user_id", nullable = false)
    private String userId;

    @Column(name = "post_title", nullable = false)
    private String title;

    @Column(name = "post_contents", nullable = false)
    private String contents;

    @Column(name = "image")
    private SerialBlob image;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "updated_at" )
    private Timestamp updatedAt;

}
