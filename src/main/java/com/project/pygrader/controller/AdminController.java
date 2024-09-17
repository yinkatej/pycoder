package com.project.pygrader.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @GetMapping("/")
    public String adminLogin() {
        return "admin/admin";
    }
    @GetMapping("/dashboard")
    public String dashboard() {
        return "admin/dashboard";
    }
}
