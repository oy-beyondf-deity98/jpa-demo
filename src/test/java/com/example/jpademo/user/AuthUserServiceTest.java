package com.example.jpademo.user;

import com.example.jpademo.user.bean.AuthUser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class AuthUserServiceTest {
    @Autowired
    AuthUserService authUserService;

    @Test
    @DisplayName("사용자 추가")
    void addUser(){
        // given
        AuthUser user = new AuthUser();
        user.setId("111");
        user.setName("김똥깡");
        // when


        // then
    }

    @Test
    @DisplayName("사용자 수정")
    void updateUser(){
        // given
        // when
        // then
    }

    @Test
    @DisplayName("사용자 삭제")
    void deleteUser(){
        // given
        // when
        // then
    }

    @Test
    @DisplayName("사용자 확인")
    void existsUser(){
        // given
        // when
        // then
    }

    @Test
    @DisplayName("사용자 ID 중복오류")
    void 중복오류(){
        // given
        // when
        // then
    }

}