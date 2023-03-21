package com.example.jpademo.code;

import com.example.jpademo.code.bean.CommonCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
class CodeServiceTest {

    @Autowired
    CodeService codeService;

    @Test
    @DisplayName("코드 생성")
    public void create() {
        CommonCode code = new CommonCode();
        code.setCode("type");
        code.setName("타입명");

        codeService.create(code);

        CommonCode findCommonCode = codeService.read(code).get();

        assertThat(code).isNotSameAs(findCommonCode);
        assertThat(code.getCode()).isEqualTo(findCommonCode.getCode());
    }

    @Test
    @DisplayName("코드 수정")
    public void update(){
        CommonCode code = new CommonCode();
        code.setCode("type");
        code.setName("타입명");

        codeService.create(code);

        CommonCode findCommonCode = codeService.read(code).get();

        findCommonCode.setName("타입명2");
        codeService.update(findCommonCode);

        CommonCode updateCommonCode = codeService.read(findCommonCode).get();


        assertThat(code).isNotSameAs(findCommonCode);
        assertThat(code).isNotSameAs(updateCommonCode);
        assertThat(findCommonCode).isSameAs(updateCommonCode);

//        assertThat(findCommonCode).isEqualTo(updateCommonCode);
        assertThat(code.getName()).isNotEqualTo(findCommonCode.getName());
        assertThat(findCommonCode.getName()).isEqualTo(updateCommonCode.getName());
    }

    @Test
    @DisplayName("코드 삭제")
    void delete(){
        // given
        CommonCode code = new CommonCode();
        code.setCode("type");
        code.setName("타입명");
        // when
        codeService.create(code);
        // then
        codeService.delete(code);

        Optional<CommonCode> commonCode = codeService.read(code);

        System.out.println("code = " + code);
        assertThat(commonCode).isEmpty();
    }

    @Test
    @DisplayName("코드 중복 확인")
    void exitsCode(){
        // given
        CommonCode code = new CommonCode();
        code.setCode("type");
        code.setName("타입명");

        codeService.create(code);
        // when
        String codeString = "type";
        boolean isCode = codeService.exitsCode(codeString);

        // then
        assertThat(isCode).isTrue();
    }

    @Test
    @DisplayName("코드 리스트")
    void codeList(){
        // given
        CommonCode code = new CommonCode();
        code.setCode("type");
        code.setName("타입명");

        codeService.create(code);

        CommonCode code2 = new CommonCode();
        code2.setCode("type2");
        code2.setName("타입명2");

        codeService.create(code2);
        // when

        List<CommonCode> commonCodeList = codeService.list();
        // then
        assertThat(commonCodeList.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("중복코드 오류")
    void codeExitsErrorTest(){
        // given
        CommonCode code = new CommonCode();
        code.setCode("type");
        code.setName("타입명");

        codeService.create(code);
        // when
        CommonCode code2 = new CommonCode();
        code2.setCode("type");
        code2.setName("타입명");

        // then
        IllegalArgumentException exception = org.junit.jupiter.api.Assertions.assertThrows(IllegalArgumentException.class, () ->
                codeService.create(code2)
        );
        // 오류 발생
        assertThat(exception.getMessage()).isEqualTo("존재합니다.");
    }

}