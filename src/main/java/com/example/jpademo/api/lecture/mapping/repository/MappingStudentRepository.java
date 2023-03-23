package com.example.jpademo.api.lecture.mapping.repository;

import com.example.jpademo.api.lecture.mapping.entity.MappingStudent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MappingStudentRepository extends JpaRepository<MappingStudent, Long> {
}
