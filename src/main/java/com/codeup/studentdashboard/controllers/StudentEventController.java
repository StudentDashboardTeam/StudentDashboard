//package com.codeup.studentdashboard.controllers;
//
//
//import com.codeup.studentdashboard.dao.repository.StudentRepository;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//
//@Controller
//public class StudentProfileController {
//
//    private final StudentRepository studentRepository;
//
//    public StudentProfileController(StudentRepository studentRepository) {
//        this.studentRepository = studentRepository;
//    }
//
//    @GetMapping("/users/studentEvents/{id}")
//    public String studentProfile(@PathVariable String id, Model model) {
//    }