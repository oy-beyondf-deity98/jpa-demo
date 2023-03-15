package com.example.jpademo.code.bean;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class CommonCode {
    @Id
    @NotEmpty
    private String code;

    @NotEmpty
    private String name;
    private int orderNum;
    private String descript;
}
