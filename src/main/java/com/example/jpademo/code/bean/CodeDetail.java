package com.example.jpademo.code.bean;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class CodeDetail {
    @Id @GeneratedValue
    Long seq;
    @ManyToOne
    CommonCode commonCode;
    String detailCode;
    String detailCodeName;

    int orderNum;
    String descript;
}
