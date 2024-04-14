package com.example.baFirstProjectTeam02.repository.comment;

import com.example.baFirstProjectTeam02.repository.posts.Posts;
import com.example.baFirstProjectTeam02.repository.users.UserEntity;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@ToString
@Builder
@Entity
@Table(name = "comments")
public class CommentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_num", nullable = false)
    private Integer commentNum;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_num")
    private Posts postNum;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity userId;

    @Column(name = "comment_contents", length = 250)
    private String commentContents;

    @CreatedBy
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @LastModifiedBy
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommentEntity that = (CommentEntity) o;
        return Objects.equals(commentNum, that.commentNum);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(commentNum);
    }
}
