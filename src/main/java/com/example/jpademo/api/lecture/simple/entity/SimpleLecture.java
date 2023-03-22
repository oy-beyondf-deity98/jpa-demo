package com.example.jpademo.api.lecture.simple.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity @Getter @Setter
public class SimpleLecture {
    @Id @GeneratedValue
    Long seq;

    String name;

    @OneToMany(mappedBy = "lecture")
    List<SimpleStudent> studentList;

    @Override
    public String toString() {
        return "SimpleLecture{" + "seq=" + seq + ", name='" + name + '\'' + '}';
    }
}
