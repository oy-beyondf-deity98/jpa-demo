package com.example.jpademo.user.auth;

import com.example.jpademo.user.bean.AuthRole;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthRoleServiceImpl implements AuthRoleService {
    final AuthRoleRepository authRoleRepository;
    @Override
    public void createRole(AuthRole role) {
        Optional<AuthRole> findRole = getRole(role);

        if (findRole.isPresent()) {
            authRoleRepository.delete(findRole.get());
//            authRoleRepository.deleteByRole(role.getRole());
        }
        authRoleRepository.save(role);
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
}
