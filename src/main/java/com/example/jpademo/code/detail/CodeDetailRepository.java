package com.example.jpademo.code.detail;

import com.example.jpademo.code.bean.CodeDetail;
import com.example.jpademo.code.bean.CommonCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CodeDetailRepository extends JpaRepository<CodeDetail, Long> {

    List<CodeDetail> findByCommonCode(CommonCode commonCode);
}
