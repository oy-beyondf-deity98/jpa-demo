package com.example.jpademo;

import com.example.jpademo.api.lecture.simple.SimpleLectureService;
import com.example.jpademo.api.lecture.simple.entity.SimpleLecture;
import com.example.jpademo.api.lecture.simple.entity.SimpleStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Configuration
public class InitDataConfiguration {
    @Autowired
    SimpleLectureService service;


    List<SimpleStudent> listStudent = new ArrayList<>();

    void initData(){
        for(int i=0;i<10;i++){
            SimpleStudent student = new SimpleStudent();
            student.setName("학생_"+i);

            SimpleStudent saveStudent = service.createStudent(student);

            listStudent.add(saveStudent);

        }
    }

    @Bean
    void ApplyingForLecture(){
        // given
        initData();
        SimpleLecture lecture = new SimpleLecture();
        lecture.setSeq(1L);
        lecture.setName("강의1");

        lecture.setStudentList(listStudent);
        SimpleLecture saveLecture = service.createLecture(lecture);

        listStudent.stream().forEach(student -> {
            student.setLecture(saveLecture);
            service.createStudent(student);
        });
        // when

        SimpleLecture findLecture = service.getLecture(lecture).get();
        findLecture.setName("강의2");

        List<SimpleLecture> listLecture = service.listLecture();
        List<SimpleStudent> listStudent = service.listStudent();

        // then

        System.out.println("saveLecture = " + saveLecture);
        System.out.println("saveLecture.getStudentList() = " + saveLecture.getStudentList());
        System.out.println("listLecture = " + listLecture);
        System.out.println("listStudent = " + listStudent);
//        System.out.println("listStudent = " + listStudent.get(0).getLectureList());
        System.out.println("listStudent.get(0).getLecture() = " + listStudent.get(0).getLecture());

    }
}
