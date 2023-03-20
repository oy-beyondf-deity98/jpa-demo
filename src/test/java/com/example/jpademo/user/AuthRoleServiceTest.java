package com.example.jpademo.user;

import com.example.jpademo.user.auth.AuthRoleService;
import com.example.jpademo.user.bean.AuthRole;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class AuthRoleServiceTest {
    @Autowired
    AuthRoleService authRoleService;

    @Test
    @DisplayName("사용자 역할 추가")
    void addRole(){
        // given
        AuthRole role = new AuthRole();
        role.setRole("ADMIN");
        authRoleService.createRole(role);
        // when
        List<AuthRole> list = authRoleService.listRole();
        // then
        assertThat(list.size()).isEqualTo(1);
    }

    @Test
    @DisplayName("같은 역할 추가")
    void sameAddRole(){
        // given
        AuthRole role = new AuthRole();
        role.setRole("ADMIN");
        authRoleService.createRole(role);

        AuthRole role2 = new AuthRole();
        role2.setRole("ADMIN");
        authRoleService.createRole(role2);
        // when
        List<AuthRole> list = authRoleService.listRole();
        // then
        assertThat(list.size()).isEqualTo(1);
    }

    @Test
    @DisplayName("다른 역할 추가 ")
    void differentAddRole(){
        // given
        AuthRole role = new AuthRole();
        role.setRole("ADMIN");
        authRoleService.createRole(role);

        AuthRole role2 = new AuthRole();
        role2.setRole("USER");
        authRoleService.createRole(role2);
        // when
        List<AuthRole> list = authRoleService.listRole();
        // then
        assertThat(list.size()).isEqualTo(2);
    }
}