package com.example.jpademo.code;

import com.example.jpademo.code.bean.CommonCode;
import com.example.jpademo.common.CrudController;
import lombok.RequiredArgsConstructor;
import org.aspectj.apache.bcel.classfile.Code;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Controller
@RequestMapping("/code")
public class CodeController implements CrudController<CommonCode, String> {
    private final CodeService service;

    @GetMapping("/list")
    public void list(Model model) {
        List<CommonCode> list = service.list();

        model.addAttribute("list",list);
    }

    @GetMapping("/register")
    public void registerForm(Model model) {
        CommonCode code = getCode(null);

        model.addAttribute("code",code);
    }

    @PostMapping("/register")
    public String register(@Validated CommonCode code, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "code/register";
        }

        service.create(code);

        redirectAttributes.addFlashAttribute("msg", "SUCCESS");

        return "redirect:/code/list";
    }

    @GetMapping("/read")
    public void read(String code, Model model) {
        CommonCode commonCode = getCode(code);
        model.addAttribute("code",commonCode);
    }

    @GetMapping("/modify")
    public void modifyForm(String code, Model model) {
        CommonCode commonCode = getCode(code);
        model.addAttribute("code",commonCode);
    }

    @PostMapping("/modify")
    public String modify(@Validated CommonCode code, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "code/modify";
        }

        service.update(code);
        redirectAttributes.addFlashAttribute("msg", "SUCCESS");
        return "redirect:/code/list";
    }

    @PostMapping("remove")
    public String remove(String code, RedirectAttributes redirectAttributes) {
        service.delete(code);

        redirectAttributes.addFlashAttribute("msg", "SUCCESS");

        return "redirect:/code/list";
    }

    private CommonCode getCode(String code) {
        if (ObjectUtils.isEmpty(code)) {
            return new CommonCode();
        }
        Optional<CommonCode> findCode = service.read(code);

        return findCode.orElse(new CommonCode());
    }
}