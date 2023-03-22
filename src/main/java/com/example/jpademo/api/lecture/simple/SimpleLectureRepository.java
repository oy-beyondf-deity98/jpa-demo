package com.example.jpademo.api.lecture.simple;

import com.example.jpademo.api.lecture.simple.entity.SimpleLecture;
import com.example.jpademo.api.lecture.simple.entity.SimpleStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SimpleLectureRepository extends JpaRepository<SimpleLecture, Long> {
}
