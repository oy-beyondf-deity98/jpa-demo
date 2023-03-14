package com.example.jpademo.code;

import com.example.jpademo.code.bean.CommonCode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommonCodeRepository extends JpaRepository<CommonCode, String> {
    Optional<CommonCode> findByCode(String code);
}
