package com.security.security.controller.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web/app/password")
@RequiredArgsConstructor
@Log
public class PasswordController {
    @GetMapping("/table")
    public String showPasswordTablePage() {
        return "password-table-form";
    }
}
