package com.security.security.controller.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web/login")
@RequiredArgsConstructor
@Log
public class LoginController {
    @GetMapping("/login-page")
    public String showLoginPage() {
        return "login-form";
    }
}
