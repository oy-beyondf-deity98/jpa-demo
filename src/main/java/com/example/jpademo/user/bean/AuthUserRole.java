package com.example.jpademo.user.bean;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
public class AuthUserRole {
    @Id @GeneratedValue
    Long seq;
    @ManyToOne
    AuthUser user;

    @ManyToOne
    AuthRole role;

    String userPassword;
}
