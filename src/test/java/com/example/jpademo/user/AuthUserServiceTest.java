package com.example.jpademo.user;

import com.example.jpademo.common.exception.ExistsException;
import com.example.jpademo.user.bean.AuthUser;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class AuthUserServiceTest {
    @Autowired
    AuthUserService authUserService;

    @Autowired
    MessageSource messageSource;

    @Test
    @DisplayName("사용자 추가")
    void addUser(){
        // given
        AuthUser user = new AuthUser();
        user.setId("111");
        user.setName("김똥깡");
        // when
        authUserService.createUser(user);

        // then
        List<AuthUser> list = authUserService.userList();
        assertThat(list.size()).isEqualTo(1);

    }

    @Test
    @DisplayName("사용자 수정")
    void updateUser(){
        // given
        AuthUser user = new AuthUser();
        user.setId("111");
        user.setName("김똥깡");
        // when
        authUserService.createUser(user);
        // when
        AuthUser updateUser = new AuthUser();
        updateUser.setId("111");
        updateUser.setName("김똥깡2");
        authUserService.createUser(updateUser);

        // then
        AuthUser getUser = authUserService.getUser(updateUser.getId()).orElseGet(null);
        assertThat(getUser.getName()).isEqualTo(updateUser.getName());

    }

    @Test
    @DisplayName("사용자 삭제")
    void deleteUser(){
        // given
        AuthUser user = new AuthUser();
        user.setId("111");
        user.setName("김똥깡");
        authUserService.createUser(user);
        // when

        authUserService.deleteUser(user.getId());

        // then
        List<AuthUser> userList = authUserService.userList();
        assertThat(userList.size()).isEqualTo(0);

    }

    @Test
    @DisplayName("사용자 확인")
    void existsUser(){
        // given
        AuthUser user = new AuthUser();
        user.setId("111");
        user.setName("김똥깡");
        authUserService.createUser(user);
        // when
        boolean existsUser = authUserService.existsUser(user.getId());
        boolean existsNotUser = authUserService.existsUser("2");
        // then
        assertThat(existsUser).isTrue();
        assertThat(existsNotUser).isFalse();


    }

    @Test
    @DisplayName("사용자 ID 중복오류")
    void 중복오류(){
        // given
        AuthUser user = new AuthUser();
        user.setId("111");
        user.setName("김똥깡");
        authUserService.createUser(user);

        // when
        AuthUser updateUser = new AuthUser();
        updateUser.setId("111");
        updateUser.setName("김똥깡2");


        // then
        ExistsException existsException = org.junit.jupiter.api.Assertions.assertThrows(ExistsException.class, () -> {
            authUserService.createUser(updateUser);
        });

        String message = messageSource.getMessage("exception_exist_user",null, Locale.KOREA);
        assertThat(existsException.getMessage()).isEqualTo(message);
    }

}