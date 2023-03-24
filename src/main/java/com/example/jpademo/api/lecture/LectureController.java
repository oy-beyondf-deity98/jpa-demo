package com.example.jpademo.api.lecture;

import com.example.jpademo.api.lecture.dto.LectureRequestDto;
import com.example.jpademo.api.lecture.mapping.LectureService;
import com.example.jpademo.api.lecture.mapping.repository.entity.MappingLecture;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/lecture")
public class LectureController {
//    final LectureService lectureService;

//    ModelMapper modelMapper = new ModelMapper();

    @GetMapping("/addLecture")
    public LectureRequestDto addLecture(LectureRequestDto lectureRequestDto){
        System.out.println("lectureRequestDto = " + lectureRequestDto);
//        lectureService.createLecture(modelMapper.map(lectureRequestDto, MappingLecture.class));

        return lectureRequestDto;
    }

    //TODO 학생 추가

    //TODO 수업 추가

    //TODO 강의 신청

    //TODO 강의 신청은 따로 분리해야 할것 같다. 주체가 학생과 담당자로 나뉠것이므로
}
