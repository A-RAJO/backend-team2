package com.example.web.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {
    private String userId;
    private String passWord;
    private String userName;
    private String phone;
    private Timestamp createAt;
}
