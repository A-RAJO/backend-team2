package com.example.baFirstProjectTeam02.repository.users;

import lombok.*;
import org.hibernate.Hibernate;
import java.util.Objects;
import jakarta.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class UserEntity {
    @Id @Column(name = "user_id")
    private Integer userId;
    @Column(name = "user_name", length = 20)
    private String userName;
    @Column(name = "phone_num", length = 11)
    private String phoneNum;
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        UserEntity that = (UserEntity) o;
        return userId != null && Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
