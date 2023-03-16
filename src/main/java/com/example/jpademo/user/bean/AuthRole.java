package com.example.jpademo.user.bean;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class AuthRole {

    @Id
    @GeneratedValue
    private Long seq;

    private String name;
}
