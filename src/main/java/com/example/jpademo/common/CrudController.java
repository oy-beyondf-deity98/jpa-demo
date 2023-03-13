package com.example.jpademo.common;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public interface CrudController<T, ID> {
    @GetMapping("/list")
    public void list(Model model);

    @GetMapping("/register")
    public void registerForm(Model model);

    @PostMapping("/register")
    public String register(@Validated T entity, BindingResult bindingResult, RedirectAttributes redirectAttributes);

    @GetMapping("/read")
    public void read(ID id, Model model);

    @GetMapping("/modify")
    public void modifyForm(ID id, Model model);

    @PostMapping("/modify")
    public String modify(@Validated T entity, BindingResult bindingResult, RedirectAttributes redirectAttributes);

    @PostMapping("/remove")
    public String remove(ID id, RedirectAttributes redirectAttributes);
}