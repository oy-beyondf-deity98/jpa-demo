package com.example.jpademo.code;

import com.example.jpademo.code.bean.CommonCode;

import java.util.List;
import java.util.Optional;

public interface CodeService {

    void create(CommonCode code);

    Optional<CommonCode> getCommonCode(CommonCode code);

    void update(CommonCode findCommonCode);

    void delete(CommonCode code);

    boolean exitsCode(String codeString);

    List<CommonCode> list();
}
