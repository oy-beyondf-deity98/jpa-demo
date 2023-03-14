package com.example.jpademo.code;

import com.example.jpademo.code.bean.CodeDetail;
import com.example.jpademo.code.bean.CommonCode;
import com.example.jpademo.code.detail.CodeDetailService;
import com.example.jpademo.common.CrudController;
import lombok.RequiredArgsConstructor;
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
@RequestMapping("/code_detail")
public class CodeDetailController {
    private final CodeDetailService service;
    private final CodeService codeService;

    @GetMapping("/list")
    public String list(CommonCode code, Model model) {
        List<CodeDetail> list = service.list(code);

        model.addAttribute("list",list);
        model.addAttribute("code", code.getCode());

        return "code_detail/list";
    }

    @GetMapping("/register")
    public void registerForm(String code, Model model) {
        CodeDetail codeDetail = getCodeDetail(null);

        CommonCode commonCode = codeService.read(code).orElseThrow();

        model.addAttribute(codeDetail);
        model.addAttribute(commonCode);
    }

    @PostMapping("/register")
    public String register(@Validated CommonCode commonCode, @Validated CodeDetail codeDetail, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "code_detail/register";
        }

        service.create(codeDetail);

        redirectAttributes.addFlashAttribute("msg", "SUCCESS");
        redirectAttributes.addFlashAttribute("commonCode", codeDetail.getCommonCode().getCode());

        return "redirect:/code_detail/list";
    }

    @GetMapping("/read")
    public void read(CodeDetail codeDetail, Model model) {
        CodeDetail findCodeDetail = getCodeDetail(codeDetail);
        model.addAttribute(findCodeDetail);
    }

    @GetMapping("/modify")
    public void modifyForm(CodeDetail codeDetail, Model model) {
        CodeDetail findCodeDetail = getCodeDetail(codeDetail);
        model.addAttribute(findCodeDetail);
    }

    @PostMapping("/modify")
    public String modify(@Validated CodeDetail codeDetail, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "code_detail/modify";
        }

        service.update(codeDetail);
        redirectAttributes.addFlashAttribute("msg", "SUCCESS");
        redirectAttributes.addFlashAttribute("commonCode", codeDetail.getCommonCode().getCode());
        return "redirect:/code_detail/list";
    }

    @PostMapping("remove")
    public String remove(@Validated CodeDetail codeDetail, RedirectAttributes redirectAttributes) {
        service.delete(codeDetail);

        redirectAttributes.addFlashAttribute("msg", "SUCCESS");
        redirectAttributes.addFlashAttribute("commonCode", codeDetail.getCommonCode().getCode());

        return "redirect:/code_detail/list";
    }

    private CodeDetail getCodeDetail(CodeDetail codeDetail) {
        if (ObjectUtils.isEmpty(codeDetail)) {
            return new CodeDetail();
        }
        Optional<CodeDetail> findCodeDetail = service.read(codeDetail);

        return findCodeDetail.orElseThrow();
    }
}