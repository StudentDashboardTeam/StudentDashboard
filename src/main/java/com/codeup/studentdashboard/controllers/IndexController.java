package com.codeup.studentdashboard.controllers;

import com.codeup.studentdashboard.dao.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    private final UserRepository userRepository;

    public IndexController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/")

    public String index(Model model) {
        String message = "Welcome from Spring";
        model.addAttribute("message", message);
        model.addAttribute("users", userRepository.findAll());

        return "index";
    }
}
