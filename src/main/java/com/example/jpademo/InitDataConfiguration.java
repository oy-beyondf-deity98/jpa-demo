package com.example.jpademo;

import com.example.jpademo.api.lecture.mapping.LectureService;
import com.example.jpademo.api.lecture.mapping.repository.entity.MappingClass;
import com.example.jpademo.api.lecture.mapping.repository.entity.MappingLecture;
import com.example.jpademo.api.lecture.mapping.repository.entity.MappingStudent;
import com.example.jpademo.api.lecture.simple.SimpleLectureService;
import com.example.jpademo.api.lecture.simple.entity.SimpleLecture;
import com.example.jpademo.api.lecture.simple.entity.SimpleStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Configuration
public class InitDataConfiguration {
    @Autowired
    SimpleLectureService service;
    @Autowired
    LectureService lectureService;

    List<SimpleStudent> listStudent = new ArrayList<>();

    List<MappingLecture> lectureList = new ArrayList<>();
    List<MappingStudent> studentList = new ArrayList<>();

    List<MappingClass> classList = new ArrayList<>();
    void initSimpleLectureData(){
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
        initSimpleLectureData();
        simpleLecture();

        initMappingLectureData();
        addClass();

    }

    void addClass(){
        // given
        List<MappingClass> selectClass = classList.stream().filter(allClass -> {
            Long seq = allClass.getSeq();
            if (seq == 0 | seq == 1 | seq == 2 | seq == 5) {
                return true;
            } else {
                return false;
            }
        }).collect(Collectors.toList());
        lectureService.applyingClass(studentList.get(0),selectClass);

        // when
        // then
    }



    private void simpleLecture() {
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


    void initMappingLectureData(){
        createLecture();
        createStudent();

        lectureList.forEach(lecture ->{
            MappingClass saveClass = createClass(lecture);
            classList.add(saveClass);
        });
    }

    private MappingClass createClass(MappingLecture lecture) {
        MappingClass mappingClass = new MappingClass();
        mappingClass.setLecture(lecture);
        mappingClass.setClassTime(2);
        mappingClass.setStartTime("11");
        mappingClass.setEndTime("13");

        MappingClass saveClass = lectureService.createClass(mappingClass);

        classList.add(saveClass);

        return saveClass;

    }

    private void createStudent() {
        for(int i=0;i<10;i++){
            MappingStudent student = new MappingStudent();
            student.setName("학생_"+i);

            MappingStudent saveStudent = lectureService.createStudent(student);

            studentList.add(saveStudent);

        }
    }

    private void createLecture() {
        MappingLecture mathLecture = new MappingLecture();
        mathLecture.setName("수학");
        MappingLecture saveMath = lectureService.createLecture(mathLecture);

        MappingLecture scienceLecture = new MappingLecture();
        scienceLecture.setName("과학");
        MappingLecture saveScience = lectureService.createLecture(scienceLecture);

        MappingLecture englishLecture = new MappingLecture();
        englishLecture.setName("영어");
        MappingLecture saveEnglish = lectureService.createLecture(englishLecture);

        lectureList.add(saveMath);
        lectureList.add(saveScience);
        lectureList.add(saveEnglish);

        for(int i=0;i<10;i++){
            MappingLecture generalElective = new MappingLecture();
            generalElective.setName("교양수업_"+i);

            MappingLecture saveGELecture = lectureService.createLecture(generalElective);

            lectureList.add(saveGELecture);
        }
    }
}
