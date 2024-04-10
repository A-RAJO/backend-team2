package com.example.baFirstProjectTeam02.web.DTO;

import com.example.baFirstProjectTeam02.repository.Entity.User;
import lombok.*;

@Getter
@Setter
public class UserDto {

    private String userId;
    private String password;
    private String userName;
    private String phone;

    @Builder
    public UserDto(String userId, String password, String userName, String phone) {
        this.userId = userId;
        this.password = password;
        this.userName = userName;
        this.phone = phone;
    }

    public User toEntity(UserDto userDto){
        return com.example.baFirstProjectTeam02.repository.Entity.User.builder()
                .userId(userId)
                .passWord(password)
                .phone(phone)
                .userName(userName)
                .build();
    }

    public UserDto toDto(User user){
        return UserDto.builder()
                .userId(userId)
                .password(password)
                .phone(phone)
                .userName(userName)
                .build();
    }
}
