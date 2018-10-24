package com.codeup.studentdashboard.controllers;


import com.codeup.studentdashboard.dao.repository.StudentRepository;
import com.codeup.studentdashboard.models.Events;
import com.codeup.studentdashboard.models.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.StreamSupport;

@Controller
public class ApplicantStatusController {

    private final StudentRepository studentRepository;

    public ApplicantStatusController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/users/applicants")
    public String studentEvent(Model model) {
        Iterable<Student> people = studentRepository.findAll();
        List<Student> applicants = new ArrayList<>();

        for (Student person : people) {

            List<Events> personsEvents = person.getEvents();
                List<String> events = new ArrayList<>();
                    for (Events event : personsEvents) {
                        events.add(event.getType().getName());
                    }

            if (!StreamSupport.stream(events.spliterator(), false).anyMatch(name -> name.equals("Rejected") ||
                                                                                    name.equals("Verbal Rejected") ||
                                                                                    name.equals("Student") ||
                                                                                    name.equals("Graduate") ||
                                                                                    name.equals("Withdrawn") ||
                                                                                    name.equals("Do Not Contact"))) {
                    applicants.add(person);
            }
        }
        model.addAttribute("applicants", applicants);

        return "/users/applicants";
    }
}

