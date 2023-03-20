package com.example.jpademo.user;

import com.example.jpademo.user.bean.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthUserRepository extends JpaRepository<AuthUser,String> {

}
