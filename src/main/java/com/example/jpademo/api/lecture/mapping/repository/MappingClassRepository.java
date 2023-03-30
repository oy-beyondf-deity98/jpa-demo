package com.example.jpademo.api.lecture.mapping.repository;

import com.example.jpademo.api.lecture.mapping.repository.entity.MappingClass;
import com.example.jpademo.api.lecture.mapping.repository.entity.MappingLecture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MappingClassRepository extends JpaRepository<MappingClass, Long> {
    Optional<MappingClass> findByLecture(MappingLecture lecture);
}
