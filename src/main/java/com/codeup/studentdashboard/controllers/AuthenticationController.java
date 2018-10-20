package com.codeup.studentdashboard.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthenticationController {
    @PostMapping("/login")
    public String showLoginForm() {
        return "loginSuccess";
    }
}
