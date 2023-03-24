package com.example.jpademo.api.lecture.mapping.repository.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class MappingApplyingClass {
    @Id @GeneratedValue
    Long seq;

    @OneToOne
    MappingClass mappingClass;

    @ManyToOne
    MappingStudent student;


}
