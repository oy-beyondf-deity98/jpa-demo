package com.example.jpademo.api.lecture.mapping;

import com.example.jpademo.api.lecture.mapping.repository.entity.MappingApplyingClass;
import com.example.jpademo.api.lecture.mapping.repository.entity.MappingClass;
import com.example.jpademo.api.lecture.mapping.repository.entity.MappingLecture;
import com.example.jpademo.api.lecture.mapping.repository.entity.MappingStudent;

import java.util.List;

public interface LectureService {
    MappingLecture createLecture(MappingLecture lecture);

    MappingStudent createStudent(MappingStudent student);

    void applyingClass(MappingStudent mappingStudent, List<MappingClass> selectClass);

    MappingClass createClass(MappingClass mappingClass);


    List<MappingApplyingClass> listLecture(MappingApplyingClass map);
}
