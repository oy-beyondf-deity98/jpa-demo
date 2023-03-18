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


    private Optional<AuthRole> getRole(AuthRole role) {
        return authRoleRepository.findByRole(role.getRole());
    }

    @Override
    public List<AuthRole> listRole() {
        return authRoleRepository.findAll();
    }

}
