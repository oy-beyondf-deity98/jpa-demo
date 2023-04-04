package com.example.jpademo.api.lecture.mapping;

import com.example.jpademo.api.lecture.mapping.repository.entity.*;
import com.example.jpademo.api.lecture.mapping.repository.MappingApplyingClassRepository;
import com.example.jpademo.api.lecture.mapping.repository.MappingClassRepository;
import com.example.jpademo.api.lecture.mapping.repository.MappingLectureRepository;
import com.example.jpademo.api.lecture.mapping.repository.MappingStudentRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class LectureServiceImpl implements LectureService {
    final MappingLectureRepository lectureRepository;
    final MappingStudentRepository studentRepository;
    final MappingClassRepository classRepository;

    final MappingApplyingClassRepository applyingClassRepository;
    final JPAQueryFactory queryFactory;    // 추가

    @Override
    public MappingLecture createLecture(MappingLecture lecture) {
        return lectureRepository.save(lecture);
    }

    @Override
    public MappingStudent createStudent(MappingStudent student) {
        return studentRepository.save(student);
    }

    @Override
    public void applyingClass(MappingStudent mappingStudent, List<MappingClass> selectClassList) {
        log.info(selectClassList.toString());
        log.info(mappingStudent.getSeq().toString());

        for (MappingClass mappingClass : selectClassList) {
            MappingApplyingClass applyingClass = new MappingApplyingClass();
            applyingClass.setMappingClass(mappingClass);
            applyingClass.setStudent(mappingStudent);

            applyingClassRepository.save(applyingClass);
        }
//
    }

    @Override
    public MappingClass createClass(MappingClass mappingClass) {
        return classRepository.save(mappingClass);
    }

    @Override
    public List<MappingApplyingClass> listLecture(MappingApplyingClass map) {
        QMappingApplyingClass findApplyingClass = QMappingApplyingClass.mappingApplyingClass;

        System.out.println("MappingApplyingClass = " + map);
        System.out.println("map.getStudent().getSeq() = " + map.getStudent().getSeq());
        if(!ObjectUtils.isEmpty(map.getStudent().getSeq())){
            List<MappingApplyingClass> fetchList = queryFactory.select(findApplyingClass).where(findApplyingClass.student.seq.eq(map.getStudent().getSeq())).fetch();
            System.out.println("fetchList = " + fetchList);
            return fetchList;

//            return applyingClassRepository.findByStudent(map.getStudent());
        }else if(!ObjectUtils.isEmpty(map.getStudent().getName())){
            return applyingClassRepository.findByStudentName(map.getStudent().getName());
        }
        return applyingClassRepository.findAll();
    }
}
