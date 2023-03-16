package com.example.jpademo.user;

import com.example.jpademo.user.bean.AuthRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthRoleRepository extends JpaRepository<AuthRole,Long> {
}
