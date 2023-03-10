package com.example.jpademo.code.detail;

import com.example.jpademo.code.bean.CodeDetail;
import com.example.jpademo.code.bean.CommonCode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CodeDetailRepository extends JpaRepository<CodeDetail, Long> {

    List<CodeDetail> findByCommonCode(CommonCode commonCode);

    Optional<CodeDetail> findByCommonCodeAndDetailCode(CommonCode commonCode, String detailCode);

    void deleteByCommonCode(CommonCode code);
}
