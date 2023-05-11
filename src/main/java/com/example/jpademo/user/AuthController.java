package com.example.jpademo.user;

import com.example.jpademo.common.CrudController;
import com.example.jpademo.user.auth.AuthRoleService;
import com.example.jpademo.user.bean.AuthRole;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Controller
@RequestMapping("/auth")
public class AuthController implements CrudController<AuthRole, Long> {
    private final AuthRoleService service;

    public void list(Model model) {
        List<AuthRole> authRoleList = service.listRole();
        model.addAttribute("list", authRoleList);
    }

    @Override
    public void registerForm(Model model) {
        AuthRole authRole = new AuthRole();

        model.addAttribute(authRole);
    }

    @Override
    public String register(@Validated AuthRole entity, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "auth/register";
        }
        service.createRole(entity);

        redirectAttributes.addFlashAttribute("msg", "SUCCESS");
        return "redirect:/auth/list";
    }

    //TODO 모두 read가 String으로 되도록 수정하자.
    @Override
    public void read(Long seq, Model model) {

    }

    @RequestMapping("/read_only")
    public String readAuth(Long seq, Model model) {
        AuthRole authRole = new AuthRole();
        authRole.setSeq(seq);

        Optional<AuthRole> role = service.findRole(seq);

        if (role.isEmpty()) {
            //TODO 값이 없다고 오류 발생 필요
            return "redirect:/auth/list";
        }else{
            model.addAttribute(role.get());
            return "auth/read";
        }
    }
    @Override
    public void modifyForm(Long seq, Model model) {
        Optional<AuthRole> role = service.findRole(seq);

        //TODO 롤이 없을때의 상황이 없네? 없으면.. 다시 화면으로 돌아가야 한다.
        model.addAttribute(role.get());
    }

    @Override
    public String modify(@Validated AuthRole entity, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "auth/modify";
        }

        service.update(entity);

        redirectAttributes.addFlashAttribute("msg", "SUCCESS");
        return "redirect:/auth/list";
    }

    @Override
    public String remove(Long seq, RedirectAttributes redirectAttributes) {
        AuthRole authRole = new AuthRole();
        authRole.setSeq(seq);

        service.remove(authRole);
        redirectAttributes.addFlashAttribute("msg", "SUCCESS");
        return "redirect:/auth/list";
    }
}
