package com.example.jpademo.api.lecture.mapping;

import com.example.jpademo.api.lecture.mapping.entity.MappingClass;
import com.example.jpademo.api.lecture.mapping.entity.MappingLecture;
import com.example.jpademo.api.lecture.mapping.entity.MappingStudent;

import java.util.List;

public interface MappingService {
    MappingLecture createLecture(MappingLecture lecture);

    MappingStudent createStudent(MappingStudent student);

    void createStudentClass(MappingStudent mappingStudent, List<MappingClass> selectClass);

    MappingClass createClass(MappingClass mappingClass);
}
