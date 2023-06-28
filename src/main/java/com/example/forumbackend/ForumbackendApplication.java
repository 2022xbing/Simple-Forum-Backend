package com.example.forumbackend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.forumbackend.mapper")
public class ForumbackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(ForumbackendApplication.class, args);
    }

}
