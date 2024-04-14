package com.example.baFirstProjectTeam02.repository.posts;

import com.example.baFirstProjectTeam02.web.dto.Postbody;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "postNum")
@EntityListeners(AuditingEntityListener.class)
@ToString
@Builder
@Entity
@Table(name = "item")
public class Posts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_num", nullable = false)
    private Integer postNum;

    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Column(name = "post_title", nullable = false)
    private String postTitle;

    @Column(name = "post_contents", nullable = false)
    private String postContents;

    @CreatedBy
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @LastModifiedBy
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    public void setPostbody(Postbody postbody) {
        this.userId=postbody.getUserId();
        this.postTitle=postbody.getPostTitle();
        this.postContents=postbody.getPostContents();
    }
}
