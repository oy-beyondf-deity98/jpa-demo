package com.example.jpademo.code;

import com.example.jpademo.code.bean.CommonCode;

import java.util.List;
import java.util.Optional;

public interface CodeService {

    void create(CommonCode code);

    Optional<CommonCode> read(String code);
    Optional<CommonCode> read(CommonCode code);

    void update(String code);
    void update(CommonCode findCommonCode);

    void delete(String code);
    void delete(CommonCode code);

    boolean exitsCode(String codeString);

    List<CommonCode> list();
}
