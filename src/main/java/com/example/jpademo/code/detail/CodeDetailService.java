package com.example.jpademo.code.detail;

import com.example.jpademo.code.bean.CodeDetail;
import com.example.jpademo.code.bean.CommonCode;

import java.util.List;

public interface CodeDetailService {
    void create(CodeDetail codeDetail);

    List<CodeDetail> listCodeDetail(CommonCode codeDetail);

    void delete(CodeDetail codeDetail);

    void update(CodeDetail updateCodeDetail);
}
