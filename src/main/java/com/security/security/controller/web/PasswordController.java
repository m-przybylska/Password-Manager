package com.security.security.controller.web;

import com.security.security.service.PasswordService;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web/app/password")
@RequiredArgsConstructor
@Log
public class PasswordController {
    private final PasswordService passwordService;

    @GetMapping("/table")
    public String showPasswordTablePage(Model model) {
        model.addAttribute("passwords", passwordService.findAll());
        return "password-table-form";
    }
}
