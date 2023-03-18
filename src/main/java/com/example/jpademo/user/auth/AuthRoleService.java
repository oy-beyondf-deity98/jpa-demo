package com.example.jpademo.user.auth;

import com.example.jpademo.user.bean.AuthRole;

import java.util.List;

public interface AuthRoleService {
    void createRole(AuthRole role);

    List<AuthRole> listRole();
}
