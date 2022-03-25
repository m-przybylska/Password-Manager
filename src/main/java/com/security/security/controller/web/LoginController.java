package com.security.security.controller.web;

import com.security.security.model.domain.User;
import com.security.security.service.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web/login")
@RequiredArgsConstructor
@Log
public class LoginController {
    private final CustomUserDetailsService customUserDetailsService;

    @GetMapping("/login-page")
    public String showLoginPage() {
        return "login-form";
    }

    @GetMapping("/register-page")
    public String showRegisterPage(Model model) {
        model.addAttribute("usr", new User());
        return "register-form";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("usr") User user, Model model) {
        customUserDetailsService.createUser(user.getLogin(), user.getPassword());
        model.addAttribute("registered", true);
        return "redirect:/web/login/login-page";
    }
}
