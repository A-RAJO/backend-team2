package com.example.repository.Entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@RequiredArgsConstructor
@ToString
@Entity
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "user_id", nullable = false,length=20)
    private String userId;

    @Column(name = "pass_word", nullable = false,length=20)
    private String passWord;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "created_at")
    private Timestamp createAt;

    @Builder
    public User (String userId, String passWord, String userName, String phone, Timestamp createAt) {
        this.userId = userId;
        this.passWord = passWord;
        this.userName = userName;
        this.phone = phone;
        this.createAt = createAt;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {return null;}

    public String getUserId() {return this.userId;}
    @Override
    public String getPassword() {
        return this.passWord;
    }

    @Override
    public String getUsername() {return this.userName;}

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}