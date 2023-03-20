package com.example.jpademo.user.auth;

import com.example.jpademo.user.bean.AuthUserRole;

import java.util.List;
import java.util.Optional;

public interface AuthUserRoleService {
    void addUserRole(AuthUserRole authUserRole);

    List<AuthUserRole> list();

    void remove(AuthUserRole authUserRole);

    void addUserRole(String adminUserId, String adminRole, String password);

    Optional<AuthUserRole> getUserRole(String username);
}
