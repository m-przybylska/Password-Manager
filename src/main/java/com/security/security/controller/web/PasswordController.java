package com.security.security.controller.web;

import com.security.security.model.domain.Password;
import com.security.security.service.PasswordService;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/add")
    public String showPasswordFormPage(Model model) {
        model.addAttribute("pass", new Password());
        return "password-form";
    }

    @GetMapping("/update")
    public String showPasswordFormPageForUpdate(@RequestParam("passwordId") Integer id, Model model) {
        model.addAttribute("pass", passwordService.findById(id));
        return "password-form";
    }

    @PostMapping("/search")
    public String search(@RequestParam("searchText") String searchText, Model model) {
        model.addAttribute("passwords", passwordService.findByWebPage(searchText));
        return "password-table-form";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("passwordId") Integer id, Model model) {
        passwordService.deleteById(id);
        return "redirect:/web/app/password/table";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("pass") Password password) {
        passwordService.save(password);
        return "redirect:/web/app/password/table";
    }


}
