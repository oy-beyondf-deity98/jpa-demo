package com.example.jpademo.code;

import com.example.jpademo.code.bean.CommonCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommonCodeRepository extends JpaRepository<CommonCode, String> {
}
