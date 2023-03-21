package com.example.jpademo.user;

import com.example.jpademo.user.auth.AuthRoleService;
import com.example.jpademo.user.bean.AuthRole;
import org.junit.jupiter.api.BeforeEach;
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

    int cntBeforeList = 0;
    @BeforeEach
    void initData(){
        List<AuthRole> list = authRoleService.listRole();

        cntBeforeList = list.size();

    }

    @Test
    @DisplayName("사용자 역할 추가")
    void addRole(){
        // given
        AuthRole role = new AuthRole();
        role.setRole("ADMIN1");
        authRoleService.createRole(role);
        // when
        AuthRole authRole = authRoleService.getRole(role).get();

        // then
        assertThat(authRole).isEqualTo(role);
    }

    /**
     * 테스트에 등록된 것이 있을때 오류가 발생한다.
     */
    @Test
    @DisplayName("같은 역할 추가")
    void sameAddRole(){
        List<AuthRole> listBefore = authRoleService.listRole();
        // given
        AuthRole role = new AuthRole();
        role.setRole("ADMIN1");
        authRoleService.createRole(role);

        AuthRole role2 = new AuthRole();
        role2.setRole("ADMIN1");
        authRoleService.createRole(role2);
        // when
        List<AuthRole> listAfter = authRoleService.listRole();
        // then
        assertThat(listAfter.size()).isEqualTo(listBefore.size()+1);

    }

    /**
     * 테스트에 등록된 것이 있을때 오류가 발생한다.
     */
    @Test
    @DisplayName("다른 역할 추가 ")
    void differentAddRole(){
        List<AuthRole> listBefore = authRoleService.listRole();
        // given
        AuthRole role = new AuthRole();
        role.setRole("ADMIN1");
        authRoleService.createRole(role);

        AuthRole role2 = new AuthRole();
        role2.setRole("USER1");
        authRoleService.createRole(role2);
        // when
        List<AuthRole> listAfter = authRoleService.listRole();
        // then
        assertThat(listAfter.size()).isEqualTo(listBefore.size()+2);
    }
}