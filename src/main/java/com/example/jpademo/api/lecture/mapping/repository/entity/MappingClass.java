package com.example.jpademo.api.lecture.mapping.repository.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class MappingClass {
    @Id @GeneratedValue
    Long seq;

    int classTime;
    String startTime;
    String endTime;

    @ManyToOne
    MappingLecture lecture;

    @Override
    public String toString() {
        return "MappingClass{" +
                "seq=" + seq +
                ", classTime=" + classTime +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                '}';
    }
}
