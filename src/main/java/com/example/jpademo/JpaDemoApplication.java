package com.example.jpademo;

import com.example.jpademo.user.AuthUserService;
import com.example.jpademo.user.auth.AuthRoleService;
import com.example.jpademo.user.auth.AuthUserRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@RequiredArgsConstructor
public class JpaDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaDemoApplication.class, args);
    }

}
