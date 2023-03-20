package com.example.jpademo.user.auth;

import com.example.jpademo.user.bean.AuthRole;
import com.example.jpademo.user.bean.AuthUserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthRoleRepository extends JpaRepository<AuthRole,Long> {
    Optional<AuthRole> findByRole(String role);

    void deleteByRole(String role);

}
