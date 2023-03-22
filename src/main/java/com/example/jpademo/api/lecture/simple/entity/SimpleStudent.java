package com.example.jpademo.api.lecture.simple.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity @Getter @Setter
public class SimpleStudent {
    @Id @GeneratedValue
    Long seq;

    String name;

    @ManyToOne
    SimpleLecture lecture;

    @Override
    public String toString() {
        return "SimpleStudent{" +"seq=" + seq + ", name='" + name + '\'' + '}';
    }
}
