package com.example.jpademo.code;

import com.example.jpademo.code.bean.CodeDetail;
import com.example.jpademo.code.bean.CommonCode;
import com.example.jpademo.code.detail.CodeDetailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class CodeServiceImpl implements CodeService {
    final CommonCodeRepository commonCodeRepository;
    final CodeDetailRepository codeDetailRepository;

    @Override
    public void create(CommonCode code) {
        Optional<CommonCode> findCommonCode = commonCodeRepository.findById(code.getCode());
        if(findCommonCode.isPresent()){
            throw new IllegalArgumentException("이미 존재하는 코드입니다.");
        }

        //Todo 테스트케이스떄문에 saveAndFlush 썼다.
        commonCodeRepository.saveAndFlush(code);
    }

    @Override
    public Optional<CommonCode> getCommonCode(CommonCode code) {
        Optional<CommonCode> findCommonCode = commonCodeRepository.findById(code.getCode());
        return findCommonCode;
    }

    @Override
    public void update(CommonCode code) {
        commonCodeRepository.save(code);
    }

    @Override
    public void delete(CommonCode code) {
        List<CodeDetail> findCodeDetailList = codeDetailRepository.findByCommonCode(code);
        if(findCodeDetailList.size() > 0){
            codeDetailRepository.deleteByCommonCode(code);
        }
        commonCodeRepository.delete(code);

    }

    @Override
    public boolean exitsCode(String codeString) {
        Optional<CommonCode> findCode = commonCodeRepository.findById(codeString);

        return findCode.isPresent();
    }

    @Override
    public List<CommonCode> list() {
        return commonCodeRepository.findAll();
    }
}
