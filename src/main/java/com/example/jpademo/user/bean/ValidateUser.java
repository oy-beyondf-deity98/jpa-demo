package com.example.jpademo.user.bean;

import com.example.jpademo.user.auth.AuthUserRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ValidateUser implements UserDetailsService {
    final AuthUserRoleService authUserRoleService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AuthUserRole authUser = authUserRoleService.getUserRole(username).get();

        String[] roleList = new String[1];
        roleList[0]  = authUser.getRole().getRole();

        return User.builder()
                .username(authUser.getUser().getId())
                .password(authUser.getUserPassword())
                .roles(roleList)
                .build();

    }

    @Bean
    public void initData(){
        authUserRoleService.addUserRole("admin","ADMIN","1234");
        authUserRoleService.addUserRole("user","USER","1234");
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
