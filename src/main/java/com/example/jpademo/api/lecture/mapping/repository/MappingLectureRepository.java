package com.example.jpademo.api.lecture.mapping.repository;

import com.example.jpademo.api.lecture.mapping.repository.entity.MappingLecture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MappingLectureRepository extends JpaRepository<MappingLecture, Long> {
}
