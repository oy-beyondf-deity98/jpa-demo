package com.example.jpademo.common;

import com.example.jpademo.api.lecture.dto.LectureRequestDto;
import com.example.jpademo.api.lecture.mapping.repository.entity.MappingLecture;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

public class ModelMapperTest {
    ModelMapper modelMapper = new ModelMapper();
    @Test
    public void entityToDto(){

        MappingLecture mappingLecture = new MappingLecture();
        mappingLecture.setName("수학");
        mappingLecture.setSeq(1L);

        LectureRequestDto lecture = modelMapper.map(mappingLecture, LectureRequestDto.class);


        Assertions.assertThat(mappingLecture.getName()).isEqualTo(lecture.getName());

    }


}
