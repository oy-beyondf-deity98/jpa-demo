package com.example.jpademo.code.bean;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
