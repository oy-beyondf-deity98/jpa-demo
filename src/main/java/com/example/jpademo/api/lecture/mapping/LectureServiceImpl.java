package com.example.jpademo.api.lecture.mapping;

import com.example.jpademo.api.lecture.mapping.repository.entity.MappingApplyingClass;
import com.example.jpademo.api.lecture.mapping.repository.entity.MappingClass;
import com.example.jpademo.api.lecture.mapping.repository.entity.MappingLecture;
import com.example.jpademo.api.lecture.mapping.repository.entity.MappingStudent;
import com.example.jpademo.api.lecture.mapping.repository.MappingApplyingClassRepository;
import com.example.jpademo.api.lecture.mapping.repository.MappingClassRepository;
import com.example.jpademo.api.lecture.mapping.repository.MappingLectureRepository;
import com.example.jpademo.api.lecture.mapping.repository.MappingStudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Marker;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class LectureServiceImpl implements LectureService {
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
    public void applyingClass(MappingStudent mappingStudent, List<MappingClass> selectClassList) {
        log.info(selectClassList.toString());
        log.info(mappingStudent.getSeq().toString());

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
