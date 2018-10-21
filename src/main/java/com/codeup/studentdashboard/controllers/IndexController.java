package com.codeup.studentdashboard.controllers;


import com.codeup.studentdashboard.dao.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class IndexController {

//    private final UserRepository userRepository;

//    public IndexController(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }

    @GetMapping("/")
    public String index(Model model) {
        String message = "Codeup Student Dashboard";
//        model.addAttribute("message", message);

//        model.addAttribute("users", userRepository.findAll());

        return "index";
    }
}

