package com.example.web.dto;

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
    private String name;
    private String phoneNum;
    private Timestamp createAt;
}
