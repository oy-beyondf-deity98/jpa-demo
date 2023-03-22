package com.example.jpademo.api.lecture.simple;

import com.example.jpademo.api.lecture.simple.entity.SimpleLecture;
import com.example.jpademo.api.lecture.simple.entity.SimpleStudent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class SimpleLectureServiceTest {

    @Autowired SimpleLectureService service;

    List<SimpleStudent> listStudent = new ArrayList<>();
    @BeforeEach
    void initData(){
        for(int i=0;i<10;i++){
            SimpleStudent student = new SimpleStudent();
            student.setName("학생_"+i);

            SimpleStudent saveStudent = service.createStudent(student);

            listStudent.add(saveStudent);

        }
    }


    @Test
    @DisplayName("학생은 강의를 등록한다")
    void ApplyingForLecture(){
        // given
        SimpleLecture lecture = new SimpleLecture();
        lecture.setName("강의1");

        // when
        SimpleLecture saveLecture = service.createLecture(lecture);
        // then

        System.out.println("saveLecture = " + saveLecture);
    }

}