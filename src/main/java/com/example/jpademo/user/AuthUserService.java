package com.example.jpademo.user;

import com.example.jpademo.user.bean.AuthUser;

import java.util.List;
import java.util.Optional;

public interface AuthUserService {
    void createUser(AuthUser user);

    List<AuthUser> userList();

    Optional<AuthUser> getUser(String userId);

    void deleteUser(String userId);

    boolean existsUser(String userId);

    void createUser(String admin);

    void updateUser(AuthUser updateUser);
}
