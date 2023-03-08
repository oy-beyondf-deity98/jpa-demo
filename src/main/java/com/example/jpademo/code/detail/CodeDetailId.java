package com.example.jpademo.code.detail;

import com.example.jpademo.code.bean.CommonCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CodeDetailId implements Serializable {
    private CommonCode code;
    private String detailCode;
}
