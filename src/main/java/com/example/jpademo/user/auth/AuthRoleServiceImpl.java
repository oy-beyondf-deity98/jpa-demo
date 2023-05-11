package com.example.jpademo.user.auth;

import com.example.jpademo.user.bean.AuthRole;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class AuthRoleServiceImpl implements AuthRoleService {
    final AuthRoleRepository authRoleRepository;
    @Override
    public void createRole(AuthRole role) {
        Optional<AuthRole> findRole = getRole(role);

        if (findRole.isPresent()) {
            authRoleRepository.save(findRole.get());
        }else{
            authRoleRepository.save(role);
        }

    }


    public Optional<AuthRole> getRole(AuthRole role) {
        return authRoleRepository.findByRole(role.getRole());
    }

    @Override
    public List<AuthRole> listRole() {
        return authRoleRepository.findAll();
    }

    @Override
    public Optional<AuthRole> getRole(String role) {
        AuthRole authRole = new AuthRole();
        authRole.setRole(role);
        return getRole(authRole);
    }

    @Override
    public void createRole(String admin) {
        AuthRole authRole = new AuthRole();
        authRole.setRole(admin);

        createRole(authRole);
    }

    @Override
    public void remove(AuthRole authRole) {
        authRoleRepository.delete(authRole);
    }

    @Override
    public void update(AuthRole entity) {
        authRoleRepository.save(entity);
    }

    @Override
    public Optional<AuthRole> findRole(Long seq) {
        return authRoleRepository.findById(seq);
    }
}
