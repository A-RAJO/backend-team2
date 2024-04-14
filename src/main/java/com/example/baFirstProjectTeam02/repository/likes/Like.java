package com.example.baFirstProjectTeam02.repository.likes;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.userdetails.User;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "likes")
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "user_id", nullable = false)
    private int userId;

    @Column(name = "post_num", nullable = false)
    private int postNum;

    public void setLike(int user){
        this.userId = userId;
    }
}