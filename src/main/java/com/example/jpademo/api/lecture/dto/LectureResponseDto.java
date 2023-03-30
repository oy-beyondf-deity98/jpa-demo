package com.example.jpademo.api.lecture.dto;

import com.example.jpademo.api.lecture.mapping.repository.entity.MappingClass;
import com.example.jpademo.api.lecture.mapping.repository.entity.MappingStudent;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LectureResponseDto {
    Long seq;

    MappingClass mappingClass;

    MappingStudent student;
}
