package com.example.jpademo.code.detail;

import com.example.jpademo.code.CodeService;
import com.example.jpademo.code.bean.CodeDetail;
import com.example.jpademo.code.bean.CommonCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
class CodeDetailServiceTest {

    @Autowired
    CodeService codeService;
    @Autowired CodeDetailService codeDetailService;


    @Test
    @DisplayName("상세 코드 추가")
    void detailInsert(){
        // given
        CommonCode code = new CommonCode();
        code.setCode("type");
        code.setName("타입명");

        codeService.create(code);


        // when
        CommonCode code2 = new CommonCode();
        code2.setCode("type");

        CodeDetail codeDetail = new CodeDetail();
        codeDetail.setCommonCode(code2);
        codeDetail.setDetailCode("10");
        codeDetail.setDetailCodeName("호두");
        codeDetail.setOrderNum(1);

        codeDetailService.create(codeDetail);

        CodeDetail codeDetail2 = new CodeDetail();
        codeDetail2.setCommonCode(code2);
        codeDetail2.setDetailCode("20");
        codeDetail2.setDetailCodeName("호두2222");
        codeDetail2.setOrderNum(2);

        codeDetailService.create(codeDetail2);

        //TODO 테스트떄에는 트랜잭션이 다 처리 안된상태에서 조회하면 오류가 발생한다. 그래서 saveAndFlush 되어야한다. 그 비슷한 상황이나..
        List<CodeDetail> list = codeDetailService.listCodeDetail(code2);


        // then
        assertThat(list.size()).isEqualTo(2);
        list.stream().forEach(findCodeDetail -> {
            assertThat(findCodeDetail.getCommonCode()).isNotNull();
        });
    }

    @Test
    @DisplayName("상세 코드 삭제")
    void detailDelete(){
        // given
        CommonCode code = new CommonCode();
        code.setCode("type");
        code.setName("타입명");

        codeService.create(code);
        CommonCode code2 = new CommonCode();
        code2.setCode("type");

        CodeDetail codeDetail = new CodeDetail();
        codeDetail.setCommonCode(code2);
        codeDetail.setDetailCode("10");
        codeDetail.setDetailCodeName("호두");
        codeDetail.setOrderNum(1);

        codeDetailService.create(codeDetail);

        CodeDetail codeDetail2 = new CodeDetail();
        codeDetail2.setCommonCode(code2);
        codeDetail2.setDetailCode("10");
        codeDetail2.setDetailCodeName("호두");
        codeDetail2.setOrderNum(1);

        codeDetailService.create(codeDetail2);

        // when
        codeDetailService.delete(codeDetail2);
        List<CodeDetail> list = codeDetailService.listCodeDetail(code2);

        // then
        assertThat(list.size()).isEqualTo(1);
    }

    @Test
    @DisplayName("상세 코드 수정")
    void detailUpdate(){
        // given
        CommonCode code = new CommonCode();
        code.setCode("type");
        code.setName("타입명");

        codeService.create(code);


        // when
        CommonCode code2 = new CommonCode();
        code2.setCode("type");

        CodeDetail codeDetail = new CodeDetail();
        codeDetail.setCommonCode(code2);
        codeDetail.setDetailCode("10");
        codeDetail.setDetailCodeName("호두");
        codeDetail.setOrderNum(1);

        codeDetailService.create(codeDetail);

        CodeDetail codeDetail2 = new CodeDetail();
        codeDetail2.setCommonCode(code2);
        codeDetail2.setDetailCode("20");
        codeDetail2.setDetailCodeName("호두");
        codeDetail2.setOrderNum(1);

        codeDetailService.create(codeDetail2);
        // when
        CodeDetail updateCodeDetail = new CodeDetail();
        updateCodeDetail.setCommonCode(code2);
        updateCodeDetail.setDetailCode(codeDetail.getDetailCode());
        updateCodeDetail.setDetailCodeName("호두222");
        updateCodeDetail.setOrderNum(1);
        updateCodeDetail.setSeq(codeDetail.getSeq());

        codeDetailService.update(updateCodeDetail);

        List<CodeDetail> codeDetailList = codeDetailService.listCodeDetail(code2);
        // then

        assertThat(codeDetailList.size()).isEqualTo(2);
        CodeDetail checkDetail = new CodeDetail();

        codeDetailList.stream().forEach(findDetail ->{
            System.out.println("findDetail.getDetailCode() = " + findDetail.getDetailCode());
            if(findDetail.getDetailCode().equals(updateCodeDetail.getDetailCode())){
                assertThat(findDetail.getDetailCodeName()).isEqualTo(updateCodeDetail.getDetailCodeName());
            }
        });
    }

    @Test
    @DisplayName("상세 코드 존재 확인")
    void detailCodeExits(){
        // given
        CommonCode code = new CommonCode();
        code.setCode("type");
        code.setName("타입명");

        codeService.create(code);

        CommonCode code2 = new CommonCode();
        code2.setCode("type");

        CodeDetail codeDetail = new CodeDetail();
        codeDetail.setCommonCode(code2);
        codeDetail.setDetailCode("10");
        codeDetail.setDetailCodeName("호두");
        codeDetail.setOrderNum(1);

        codeDetailService.create(codeDetail);

        // when
        boolean exitsCodeDetail = codeDetailService.exitsCodeDetail(codeDetail.getCommonCode(), codeDetail.getDetailCode());

        // then
        assertThat(exitsCodeDetail).isTrue();
    }

    @Test
    @DisplayName("상세 코드 중복 저장 확인")
    void detailCodeDuplicationError(){
        // given
        CommonCode code = new CommonCode();
        code.setCode("type");
        code.setName("타입명");

        codeService.create(code);


        // when
        CommonCode code2 = new CommonCode();
        code2.setCode("type");

        CodeDetail codeDetail = new CodeDetail();
        codeDetail.setCommonCode(code2);
        codeDetail.setDetailCode("10");
        codeDetail.setDetailCodeName("호두");
        codeDetail.setOrderNum(1);

        codeDetailService.create(codeDetail);

        // when
        CodeDetail codeDetail2 = new CodeDetail();
        codeDetail2.setCommonCode(code2);
        codeDetail2.setDetailCode("10");
        codeDetail2.setDetailCodeName("호두");
        codeDetail2.setOrderNum(1);


        // then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            codeDetailService.create(codeDetail2);
        });

        assertThat(exception.getMessage()).isEqualTo("코드가 존재합니다.");
    }

    @Test
    @DisplayName("공통 코드 삭제할때 하위 코드 모두 삭제 확인")
    void deleteCommonCodeClear(){
        // given
        // given
        CommonCode code = new CommonCode();
        code.setCode("type");
        code.setName("타입명");

        codeService.create(code);


        // when
        CommonCode code2 = new CommonCode();
        code2.setCode("type");

        CodeDetail codeDetail = new CodeDetail();
        codeDetail.setCommonCode(code2);
        codeDetail.setDetailCode("10");
        codeDetail.setDetailCodeName("호두");
        codeDetail.setOrderNum(1);

        codeDetailService.create(codeDetail);

        CodeDetail codeDetail2 = new CodeDetail();
        codeDetail2.setCommonCode(code2);
        codeDetail2.setDetailCode("20");
        codeDetail2.setDetailCodeName("호두2222");
        codeDetail2.setOrderNum(2);

        codeDetailService.create(codeDetail2);

        // when
        codeService.delete(code);

        // then
        CommonCode code3 = new CommonCode();
        code3.setCode("type");
        List<CodeDetail> codeDetailList = codeDetailService.listCodeDetail(code3);
        assertThat(codeDetailList.size()).isEqualTo(0);
    }
}