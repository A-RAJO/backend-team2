package com.example.web.DTO;

import lombok.*;
import org.springframework.security.core.userdetails.User;

@Getter
@Setter
public class SignUp {

    private String userId;
    private String password;
    private String userName;
    private String phone;


}
