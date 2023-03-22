package com.example.jpademo.code;

import com.example.jpademo.code.bean.CodeDetail;
import com.example.jpademo.code.bean.CommonCode;
import com.example.jpademo.code.detail.CodeDetailRepository;
import com.example.jpademo.common.exception.ExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class CodeServiceImpl implements CodeService {
    final CommonCodeRepository commonCodeRepository;
    final CodeDetailRepository codeDetailRepository;
    final MessageSource messageSource;

    @Override
    public void create(CommonCode code) {
        Optional<CommonCode> findCommonCode = read(code.getCode());
        if(findCommonCode.isPresent()){
            String message = messageSource.getMessage("exception_exist",null, Locale.KOREA);
            throw new ExistsException(message);
        }

        //Todo 테스트케이스떄문에 saveAndFlush 썼다.
        commonCodeRepository.save(code);
    }

    @Override
    public Optional<CommonCode> read(String code) {
        CommonCode commonCode = new CommonCode();
        commonCode.setCode(code);

        return read(commonCode);
    }

    @Override
    public Optional<CommonCode> read(CommonCode code) {
        return commonCodeRepository.findById(code.getCode());
    }

    @Override
    public void update(String code) {
        CommonCode commonCode = new CommonCode();
        commonCode.setCode(code);

        update(commonCode);
    }

    @Override
    public void update(CommonCode code) {
        commonCodeRepository.save(code);
    }

    @Override
    public void delete(String code) {
        CommonCode commonCode = new CommonCode();
        commonCode.setCode(code);

        delete(commonCode);
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
        Optional<CommonCode> findCode = read(codeString);

        return findCode.isPresent();
    }

    @Override
    public List<CommonCode> list() {
        return commonCodeRepository.findAll();
    }
}
