package com.example.jpademo.user.auth;

import com.example.jpademo.user.bean.AuthUserRole;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthUserRoleServiceImpl implements AuthUserRoleService {
    final AuthUserRoleRepository repository;
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
}
