package com.example.jpademo.code.bean;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class CommonCode {
    @Id
    private String code;

    private String name;
    private int orderNum;
    private String descript;
}
