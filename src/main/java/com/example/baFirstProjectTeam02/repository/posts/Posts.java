package com.example.baFirstProjectTeam02.repository.posts;

import com.example.baFirstProjectTeam02.repository.users.UserEntity;
import com.example.baFirstProjectTeam02.web.dto.Postbody;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Builder
@Entity
@Table(name = "posts")
public class Posts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_num", nullable = false)
    private Integer postNum;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private UserEntity userId;

    @Column(name = "post_title", nullable = false, length = 30)
    private String postTitle;

    @Column(name = "post_contents", nullable = false,length = 2000)
    private String postContents;

    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;


    public void setPostbody(Postbody postbody) {
        this.userId=postbody.getUserId();
        this.postTitle=postbody.getPostTitle();
        this.postContents=postbody.getPostContents();
    }
}
