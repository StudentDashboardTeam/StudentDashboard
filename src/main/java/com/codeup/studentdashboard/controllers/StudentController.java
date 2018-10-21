package com.codeup.studentdashboard.controllers;

import com.codeup.studentdashboard.dao.repository.StudentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentController {

    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/users/students")
    public String student(Model model) {
        model.addAttribute("students", studentRepository.findAll());
        return "/users/students";
    }
}