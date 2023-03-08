package com.example.jpademo;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String home(Model model) {
        LocalDateTime now = LocalDateTime.now();
        model.addAttribute("serverTime", now);

        return "home";
    }
}
