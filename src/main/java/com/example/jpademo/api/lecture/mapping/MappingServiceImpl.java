package com.example.jpademo.api.lecture.mapping;

import com.example.jpademo.api.lecture.mapping.entity.MappingApplyingClass;
import com.example.jpademo.api.lecture.mapping.entity.MappingClass;
import com.example.jpademo.api.lecture.mapping.entity.MappingLecture;
import com.example.jpademo.api.lecture.mapping.entity.MappingStudent;
import com.example.jpademo.api.lecture.mapping.repository.MappingApplyingClassRepository;
import com.example.jpademo.api.lecture.mapping.repository.MappingClassRepository;
import com.example.jpademo.api.lecture.mapping.repository.MappingLectureRepository;
import com.example.jpademo.api.lecture.mapping.repository.MappingStudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class MappingServiceImpl implements MappingService {
    final MappingLectureRepository lectureRepository;
    final MappingStudentRepository studentRepository;
    final MappingClassRepository classRepository;

    final MappingApplyingClassRepository applyingClassRepository;

    @Override
    public MappingLecture createLecture(MappingLecture lecture) {
        return lectureRepository.save(lecture);
    }

    @Override
    public MappingStudent createStudent(MappingStudent student) {
        return studentRepository.save(student);
    }

    @Override
    public void createStudentClass(MappingStudent mappingStudent, List<MappingClass> selectClassList) {
        System.out.println("selectClassList = " + selectClassList);
        System.out.println("mappingStudent.getSeq() = " + mappingStudent.getSeq());

        for (MappingClass mappingClass : selectClassList) {
            MappingApplyingClass applyingClass = new MappingApplyingClass();
            applyingClass.setMappingClass(mappingClass);
            applyingClass.setStudent(mappingStudent);

            applyingClassRepository.save(applyingClass);
        }
//
    }

    @Override
    public MappingClass createClass(MappingClass mappingClass) {
        return classRepository.save(mappingClass);
    }
}
