package com.example.jpademo.user.bean;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
@Data
@Entity

public class AuthUser {
    @Id
    String id;

    String name;

    //사용자 타입?
    //사용자 권한타입?
}
