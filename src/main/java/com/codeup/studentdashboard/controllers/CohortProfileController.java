package com.codeup.studentdashboard.controllers;

import com.codeup.studentdashboard.dao.repository.CohortRepository;
import com.codeup.studentdashboard.dao.repository.StudentRepository;
import com.codeup.studentdashboard.models.Cohort;
import com.codeup.studentdashboard.models.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class CohortProfileController {

    private final CohortRepository cohortRepository;
    private final StudentRepository studentRepository;


    public CohortProfileController(CohortRepository cohortRepository, StudentRepository studentRepository) {
        this.cohortRepository = cohortRepository;
        this.studentRepository = studentRepository;
    }

    @GetMapping("/users/cohorts/{id}")
    public String cohortProfile(@PathVariable String id, Model model) {
        Long idNumber = Long.parseLong(id);

        Cohort currentCohort = cohortRepository.findById(idNumber);
        model.addAttribute("cohort", currentCohort);

        Iterable<Student> studentInCohort = studentRepository.findAll();
        int studentCount = 0;
        for (Student stu : studentInCohort) {
            Cohort co = stu.getCohort();
            if (co != null && co.getId() == currentCohort.getId()) {
                studentCount++;
            }
        }

        model.addAttribute("studentCount", studentCount);

        return "/users/cohortProfile";
    }

}

