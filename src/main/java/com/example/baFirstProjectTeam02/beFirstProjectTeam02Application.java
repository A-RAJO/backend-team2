package com.example.baFirstProjectTeam02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
@ComponentScan("com.example.baFirstProjectTeam02.repository")
public class beFirstProjectTeam02Application {
    public static void main(String[] args) {
        SpringApplication.run(beFirstProjectTeam02Application.class, args);
    }

}
