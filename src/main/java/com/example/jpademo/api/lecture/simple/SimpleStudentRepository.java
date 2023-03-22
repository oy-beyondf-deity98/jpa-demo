package com.example.jpademo.api.lecture.simple;

import com.example.jpademo.api.lecture.simple.entity.SimpleStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SimpleStudentRepository extends JpaRepository<SimpleStudent, Long> {

//    @Query(value="select s.seq, s.name, (select lecture from SimpleLecture lecture where lecture.studentList in (s.seq)) as lecture from SimpleStudent s")
//    SimpleStudent jpqlStudent();
}
