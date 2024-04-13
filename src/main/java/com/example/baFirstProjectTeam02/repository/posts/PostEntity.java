package com.example.baFirstProjectTeam02.repository.posts;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Blob;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "post_num")
@ToString
@Builder
@Entity
@Table(name = "item")
public class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "post_num", nullable = false)
    private int post_num;

    @Column(name = "user_id", nullable = false)
    private int userId;

    @Column(name = "post_title", nullable = false)
    private String postTitle;

    @Column(name = "post_contents", nullable = false)
    private String post_contents;

    @Column(name = "image", nullable = false)
    private PostImage image;

    @Column(name = "created_at", nullable = false)
    private Timestamp createdAt;

    @Column(name = "updated_at", nullable = false)
    private Timestamp updatedAt;

}
