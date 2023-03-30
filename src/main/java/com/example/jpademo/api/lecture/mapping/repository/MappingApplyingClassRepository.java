package com.example.jpademo.api.lecture.mapping.repository;

import com.example.jpademo.api.lecture.mapping.repository.entity.MappingApplyingClass;
import com.example.jpademo.api.lecture.mapping.repository.entity.MappingStudent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MappingApplyingClassRepository extends JpaRepository<MappingApplyingClass, Long> {

    List<MappingApplyingClass> findByStudent(MappingStudent student);

    List<MappingApplyingClass> findByStudentName(String name);
}
