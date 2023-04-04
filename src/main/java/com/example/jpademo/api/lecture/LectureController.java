package com.example.jpademo.api.lecture;

import com.example.jpademo.api.lecture.dto.LectureRequestDto;
import com.example.jpademo.api.lecture.dto.LectureResponseDto;
import com.example.jpademo.api.lecture.mapping.LectureService;
import com.example.jpademo.api.lecture.mapping.repository.entity.MappingApplyingClass;
import com.example.jpademo.api.lecture.mapping.repository.entity.MappingLecture;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/lecture")
public class LectureController {
    final LectureService lectureService;

    ModelMapper modelMapper = new ModelMapper();


    @GetMapping("/listLecture")
    public List<LectureResponseDto> listLecture(@RequestBody LectureRequestDto lectureRequestDto){
        System.out.println("lectureRequestDto = " + lectureRequestDto);

        MappingApplyingClass serviceMap = modelMapper.map(lectureRequestDto, MappingApplyingClass.class);
        List<MappingApplyingClass> mappingApplyingClassList = lectureService.listLecture(serviceMap);

        List<LectureResponseDto> outList =  mappingApplyingClassList.stream().map(rtnData ->{

            LectureResponseDto dto = modelMapper.map(rtnData, LectureResponseDto.class);

            return dto;

        }).collect(Collectors.toList());

        return outList;
    }

    //TODO 학생 추가

    //TODO 수업 추가

    //TODO 강의 신청

    //TODO 강의 신청은 따로 분리해야 할것 같다. 주체가 학생과 담당자로 나뉠것이므로
}
