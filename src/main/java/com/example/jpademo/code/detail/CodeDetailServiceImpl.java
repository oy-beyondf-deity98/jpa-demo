package com.example.jpademo.code.detail;

import com.example.jpademo.code.bean.CodeDetail;
import com.example.jpademo.code.bean.CommonCode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
//@RequiredArgsConstructor
public class CodeDetailServiceImpl implements CodeDetailService {
    final CodeDetailRepository codeDetailRepository;

    public CodeDetailServiceImpl(CodeDetailRepository codeDetailRepository) {
        this.codeDetailRepository = codeDetailRepository;


    }

    @Override
    public void create(CodeDetail codeDetail) {
        System.out.println("codeDetail.getCommonCode() = " + codeDetail.getCommonCode());
        boolean exitsCodeDetail = this.exitsCodeDetail(codeDetail);
        if(exitsCodeDetail){
            throw new IllegalArgumentException("코드가 존재합니다.");
        }
        codeDetailRepository.save(codeDetail);

    }

    private boolean exitsCodeDetail(CodeDetail codeDetail) {
        return this.exitsCodeDetail(codeDetail.getCommonCode(), codeDetail.getDetailCode());
    }

    @Override
    public List<CodeDetail> list(CommonCode commonCode) {
        return codeDetailRepository.findByCommonCode(commonCode);
    }

    @Override
    public void delete(CodeDetail codeDetail) {
        codeDetailRepository.delete(codeDetail);
    }

    @Override
    public void update(CodeDetail updateCodeDetail) {
        System.out.println("updateCodeDetail.getDetailCodeName() = " + updateCodeDetail.getDetailCodeName());
        if (updateCodeDetail.getSeq() == null) {
            throw new IllegalArgumentException("키값이 존재하지 않습니다.");
        }
        codeDetailRepository.save(updateCodeDetail);
    }

    @Override
    public boolean exitsCodeDetail(CommonCode commonCode, String detailCode) {
        Optional<CodeDetail> findCodeDetail = codeDetailRepository.findByCommonCodeAndDetailCode(commonCode, detailCode);
        return findCodeDetail.isPresent();
    }

    @Override
    public Optional<CodeDetail> read(CodeDetail codeDetail) {
        return codeDetailRepository.findById(codeDetail.getSeq());
    }
}
