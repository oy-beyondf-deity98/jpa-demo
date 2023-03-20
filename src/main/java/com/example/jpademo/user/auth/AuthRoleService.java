package com.example.jpademo.user.auth;

import com.example.jpademo.user.bean.AuthRole;

import java.util.List;
import java.util.Optional;

public interface AuthRoleService {
    void createRole(AuthRole role);

    Optional<AuthRole> getRole(AuthRole role);

    List<AuthRole> listRole();

    Optional<AuthRole>  getRole(String role);

    void createRole(String admin);
}
