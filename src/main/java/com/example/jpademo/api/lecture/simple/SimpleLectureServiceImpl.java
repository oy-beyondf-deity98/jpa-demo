package com.example.jpademo.api.lecture.simple;

import com.example.jpademo.api.lecture.simple.entity.SimpleLecture;
import com.example.jpademo.api.lecture.simple.entity.SimpleStudent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class SimpleLectureServiceImpl implements SimpleLectureService {
    final SimpleStudentRepository simpleStudentRepository;
    final SimpleLectureRepository simpleLectureRepository;
    @Override
    public SimpleStudent createStudent(SimpleStudent student) {
        return simpleStudentRepository.save(student);

    }

    @Override
    public SimpleLecture createLecture(SimpleLecture lecture) {
        return simpleLectureRepository.save(lecture);
    }

    @Override
    public List<SimpleLecture> listLecture() {

        return simpleLectureRepository.findAll();
    }

    @Override
    public List<SimpleStudent> listStudent() {
        return simpleStudentRepository.findAll();
    }

    @Override
    public Optional<SimpleLecture> getLecture(SimpleLecture lecture) {
        return simpleLectureRepository.findById(lecture.getSeq());
    }

//    @Override
//    public List<SimpleStudent> jpqlStudentList() {
//        return simpleLectureRepository.jpqlStudentList();
//    }

}
