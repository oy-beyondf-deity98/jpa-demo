package com.example.jpademo.api.lecture.simple;

import com.example.jpademo.api.lecture.simple.entity.SimpleLecture;
import com.example.jpademo.api.lecture.simple.entity.SimpleStudent;

import java.util.List;
import java.util.Optional;

public interface SimpleLectureService {
    SimpleStudent createStudent(SimpleStudent student);

    SimpleLecture createLecture(SimpleLecture lecture);

    List<SimpleLecture> listLecture();

    List<SimpleStudent> listStudent();

    Optional<SimpleLecture> getLecture(SimpleLecture lecture);

//    List<SimpleStudent> jpqlStudentList();
}
