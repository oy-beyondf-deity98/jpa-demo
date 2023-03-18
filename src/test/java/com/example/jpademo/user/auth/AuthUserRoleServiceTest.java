package com.example.jpademo.user.auth;

import com.example.jpademo.user.AuthUserService;
import com.example.jpademo.user.bean.AuthRole;
import com.example.jpademo.user.bean.AuthUser;
import com.example.jpademo.user.bean.AuthUserRole;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class AuthUserRoleServiceTest {
    @Autowired
    AuthUserService authUserService;

    @Autowired
    AuthRoleService authRoleService;

    @Autowired
    AuthUserRoleService authUserRoleService;

    AuthUser user;
    List<AuthRole> roleList = new ArrayList<>();

    @BeforeEach
    void baseData(){
        user = new AuthUser();
        user.setId("111");
        user.setName("김상겸");
        authUserService.createUser(user);

        AuthRole authRole1 = new AuthRole();
        authRole1.setRole("PL");
        authRoleService.createRole(authRole1);

        System.out.println("authRole1 = " + authRole1);
        AuthRole authRole2 = new AuthRole();
        authRole2.setRole("PM");
        authRoleService.createRole(authRole2);

        roleList.add(authRole1);
        roleList.add(authRole2);
    }

    @Test
    @DisplayName("사용자 권한 추가")
    void addUserRole(){
        // given
        AuthUserRole authUserRole = new AuthUserRole();
        authUserRole.setUser(user);
        authUserRole.setRole(roleList.get(0));

        // when
        authUserRoleService.addUserRole(authUserRole);
        // then
        List<AuthUserRole> list = authUserRoleService.list();
        Assertions.assertThat(list.size()).isEqualTo(1);
    }

    @Test
    @DisplayName("같은 권한 입력했을때 덥어씌우기")
    void samRoleConfirm(){
        // given
        AuthUserRole authUserRole = new AuthUserRole();
        authUserRole.setUser(user);
        authUserRole.setRole(roleList.get(0));
        authUserRoleService.addUserRole(authUserRole);
        // when
        AuthUserRole authUserRole2 = new AuthUserRole();
        authUserRole2.setUser(user);
        authUserRole2.setRole(roleList.get(0));
        authUserRoleService.addUserRole(authUserRole2);
        // then
        List<AuthUserRole> list = authUserRoleService.list();
        Assertions.assertThat(list.size()).isEqualTo(1);
    }

    @Test
    @DisplayName("같은 사용자 다른 권한 입력했을때는 추가 된다")
    void diffRoleConfirm(){
        // given
        AuthUserRole authUserRole = new AuthUserRole();
        authUserRole.setUser(user);
        authUserRole.setRole(roleList.get(0));
        authUserRoleService.addUserRole(authUserRole);
        // when
        AuthUserRole authUserRole2 = new AuthUserRole();
        authUserRole2.setUser(user);
        authUserRole2.setRole(roleList.get(1));
        authUserRoleService.addUserRole(authUserRole2);

        // then
        List<AuthUserRole> list = authUserRoleService.list();
        Assertions.assertThat(list.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("사용자 권한 제거")
    void removeUserRole(){
        // given
        AuthUserRole authUserRole = new AuthUserRole();
        authUserRole.setUser(user);
        authUserRole.setRole(roleList.get(0));
        authUserRoleService.addUserRole(authUserRole);
        // when
        authUserRoleService.remove(authUserRole);
        // then
        List<AuthUserRole> list = authUserRoleService.list();
        Assertions.assertThat(list.size()).isEqualTo(0);
    }
}