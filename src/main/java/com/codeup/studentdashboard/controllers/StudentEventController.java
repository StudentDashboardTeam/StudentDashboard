package com.codeup.studentdashboard.controllers;


import com.codeup.studentdashboard.dao.repository.StudentRepository;
import com.codeup.studentdashboard.models.EventType;
import com.codeup.studentdashboard.models.Events;
import com.codeup.studentdashboard.models.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class StudentEventController {

    private final StudentRepository studentRepository;

    public StudentEventController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/users/studentEvents/{id}")
    public String studentEvent(@PathVariable String id, Model model) {

        Long idNumber = Long.parseLong(id);

        Student currentStudent = studentRepository.findById(idNumber);
        model.addAttribute("student", currentStudent);

        List<Events> studentEvents = currentStudent.getEvents();
        model.addAttribute("studentEvents", studentEvents);

        return "/users/studentEvents";
    }
}