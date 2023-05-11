package com.example.jpademo.user;

import com.example.jpademo.common.CrudController;
import com.example.jpademo.user.bean.AuthUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Controller
@RequestMapping("/user")

public class UserController implements CrudController<AuthUser, String> {
    private final AuthUserService service;

    @Override
    public void list(Model model) {
        List<AuthUser> authUserList = service.userList();
        model.addAttribute("list", authUserList);
    }

    @Override
    public void registerForm(Model model) {
        AuthUser user = new AuthUser();
        model.addAttribute(user);
    }

    @Override
    public String register(@Validated AuthUser entity, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "user/register";
        }

        service.createUser(entity);

        redirectAttributes.addFlashAttribute("msg", "SUCCESS");

        return "redirect:/user/list";
    }

    @Override
    public void read(String id, Model model) {
        AuthUser requestUser = new AuthUser();
        requestUser.setId(id);

        Optional<AuthUser> findUser = service.getUser(id);

        if (findUser.isEmpty()) {
            //TODO 오류, 그리고 화면으로 이동
        }else {
            model.addAttribute(findUser.get());
        }
    }

    @Override
    public void modifyForm(String id, Model model) {
        AuthUser requestUser = new AuthUser();
        requestUser.setId(id);

        Optional<AuthUser> findUser = service.getUser(id);

        if (findUser.isEmpty()) {
            //TODO 오류, 그리고 화면으로 이동
        }else {
            model.addAttribute(findUser.get());
        }
    }

    @Override
    public String modify(AuthUser entity, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "user/modify";
        }

        service.updateUser(entity);

        redirectAttributes.addFlashAttribute("msg", "SUCCESS");
        return "redirect:/user/list";
    }

    @Override
    public String remove(String id, RedirectAttributes redirectAttributes) {
        service.deleteUser(id);
        redirectAttributes.addFlashAttribute("msg", "SUCCESS");

        return "redirect:/user/list";
    }
}
