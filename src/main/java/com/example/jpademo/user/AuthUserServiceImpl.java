package com.example.jpademo.user;

import com.example.jpademo.common.exception.ExistsException;
import com.example.jpademo.user.bean.AuthUser;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthUserServiceImpl implements AuthUserService {
    private final AuthUserRepository authUserRepository;
    final MessageSource messageSource;
    @Override
    public void createUser(AuthUser user) {
        Optional<AuthUser> findUser = getUser(user.getId());
        if (findUser.isPresent()) {
            String message = messageSource.getMessage("exception_exist_user",null, Locale.KOREA);
            throw new ExistsException(message);
        }
        authUserRepository.save(user);
    }

    @Override
    public List<AuthUser> userList() {
        return authUserRepository.findAll();
    }

    @Override
    public Optional<AuthUser> getUser(String userId) {
        return authUserRepository.findById(userId);
    }

    @Override
    public void deleteUser(String userId) {
        authUserRepository.deleteById(userId);
    }

    @Override
    public boolean existsUser(String userId) {
        Optional<AuthUser> user = getUser(userId);
        return user.isPresent();
    }

    @Override
    public void createUser(String admin) {

    }

}
