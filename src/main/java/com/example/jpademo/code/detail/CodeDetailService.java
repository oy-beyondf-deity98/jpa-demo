package com.example.jpademo.code.detail;

import com.example.jpademo.code.bean.CodeDetail;
import com.example.jpademo.code.bean.CommonCode;

import java.util.List;
import java.util.Optional;

public interface CodeDetailService {
    void create(CodeDetail codeDetail);

    List<CodeDetail> list(CommonCode codeDetail);

    void delete(CodeDetail codeDetail);

    void update(CodeDetail updateCodeDetail);

    boolean exitsCodeDetail(CommonCode commonCode, String detailCode);

    Optional<CodeDetail> read(CodeDetail codeDetail);
}
