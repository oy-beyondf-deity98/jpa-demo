package com.example.jpademo.user.auth;

import com.example.jpademo.user.bean.AuthUserRole;

import java.util.List;

public interface AuthUserRoleService {
    void addUserRole(AuthUserRole authUserRole);

    List<AuthUserRole> list();

    void remove(AuthUserRole authUserRole);
}
