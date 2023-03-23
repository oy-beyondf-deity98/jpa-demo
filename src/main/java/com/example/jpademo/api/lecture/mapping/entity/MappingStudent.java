package com.example.jpademo.api.lecture.mapping.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class MappingStudent {
    @Id @GeneratedValue
    Long seq;

    String name;

}
