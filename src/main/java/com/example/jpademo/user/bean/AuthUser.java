package com.example.jpademo.user.bean;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Data
@Entity

public class AuthUser {
    @Id
    @NotBlank
    String id;

    @NotBlank
    String name;


}
