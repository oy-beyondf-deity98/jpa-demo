package com.example.jpademo.user.auth;

import com.example.jpademo.user.AuthUserRepository;
import com.example.jpademo.user.AuthUserService;
import com.example.jpademo.user.bean.AuthRole;
import com.example.jpademo.user.bean.AuthUser;
import com.example.jpademo.user.bean.AuthUserRole;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthUserRoleServiceImpl implements AuthUserRoleService {
    final AuthUserRoleRepository repository;
    final AuthUserService authUserService;

    final AuthRoleService authRoleService;

    final AuthUserRepository authUserRepository;
    final AuthRoleRepository authRoleRepository;

    @Override
    public void addUserRole(AuthUserRole authUserRole) {
        Optional<AuthUserRole> findUserRole = repository.findByUserAndRole(authUserRole.getUser(), authUserRole.getRole());
        if (findUserRole.isEmpty()) {
            repository.save(authUserRole);
        }
    }

    @Override
    public List<AuthUserRole> list() {
        return repository.findAll();
    }

    @Override
    public void remove(AuthUserRole authUserRole) {
        repository.delete(authUserRole);

    }

    @Override
    //TODO 오류가 발생한다.
    public void addUserRole(String adminUserId, String adminRole, String password) {

        Optional<AuthUser> user = authUserRepository.findById(adminUserId);
        AuthUser authUser = new AuthUser();

        if(user.isEmpty()){
            authUser.setId(adminUserId);
            authUser.setName(adminUserId.toUpperCase());
            authUserRepository.saveAndFlush(authUser);

            authUser = authUserRepository.findById(adminUserId).orElseGet(null);
        }else{
            authUser = user.get();
        }

        Optional<AuthRole> role = authRoleRepository.findByRole(adminRole);
//        Optional<AuthRole> role = authRoleService.getRole(adminRole);
        AuthRole authRole = new AuthRole();
        if (role.isEmpty()) {
            authRole.setRole(adminRole);
            authRoleRepository.saveAndFlush(authRole);

            authRole = authRoleRepository.findByRole(authRole.getRole()).get();

//            authRoleService.createRole(authRole);
        }else{
            authRole = role.get();
        }

        String newPassword = new BCryptPasswordEncoder().encode(password);

        AuthUserRole authUserRole = new AuthUserRole();
        authUserRole.setUser(authUser);
        authUserRole.setRole(authRole);
        authUserRole.setUserPassword(newPassword);
        addUserRole(authUserRole);

    }

    @Override
    public Optional<AuthUserRole> getUserRole(String username) {
        AuthUser adminUser = new AuthUser();
        adminUser.setId(username);

        Optional<AuthUserRole> user = repository.findByUser(adminUser);
        System.out.println("user = " + user);
        return user;

    }
}
