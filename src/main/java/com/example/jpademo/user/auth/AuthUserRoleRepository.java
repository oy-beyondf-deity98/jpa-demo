package com.example.jpademo.user.auth;

import com.example.jpademo.user.bean.AuthRole;
import com.example.jpademo.user.bean.AuthUser;
import com.example.jpademo.user.bean.AuthUserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthUserRoleRepository extends JpaRepository<AuthUserRole, Long> {
    Optional<AuthUserRole> findByUserAndRole(AuthUser user, AuthRole role);
}
