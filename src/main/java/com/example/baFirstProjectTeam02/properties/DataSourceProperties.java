package com.example.baFirstProjectTeam02.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

@Getter
@Setter
@ConfigurationProperties
public class DataSourceProperties {
    private String username;
    private String password;
    private String driverClassName;
    private String url;
}