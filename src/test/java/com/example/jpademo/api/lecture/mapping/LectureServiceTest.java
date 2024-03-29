package com.example.jpademo.api.lecture.mapping;

import com.example.jpademo.api.lecture.mapping.repository.entity.MappingClass;
import com.example.jpademo.api.lecture.mapping.repository.entity.MappingLecture;
import com.example.jpademo.api.lecture.mapping.repository.entity.MappingStudent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
@Transactional
class LectureServiceTest {
    @Autowired
    LectureService lectureService;

    List<MappingLecture> lectureList = new ArrayList<>();
    List<MappingStudent> studentList = new ArrayList<>();

    List<MappingClass> classList = new ArrayList<>();
    @BeforeEach
    void initData(){
        createLecture();

        createStudent();

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

    @Test
    @DisplayName("수업 추가")
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

}