package com.codeup.studentdashboard.controllers;

import com.codeup.studentdashboard.dao.repository.CohortRepository;
import com.codeup.studentdashboard.dao.repository.StudentRepository;
import com.codeup.studentdashboard.models.Cohort;
import com.codeup.studentdashboard.models.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;

@Controller
public class CohortProfileController {

    private final CohortRepository cohortRepository;

    public CohortProfileController(CohortRepository cohortRepository) {
        this.cohortRepository = cohortRepository;
    }

    @GetMapping("/users/cohorts/{id}")
    public String cohortProfile(@PathVariable String id, Model model) {
        Long idNumber = Long.parseLong(id);

        Cohort currentCohort = cohortRepository.findById(idNumber);
            model.addAttribute("cohort", currentCohort);

        LocalDate startDate = currentCohort.getStartDate();
            long daysUntilCohortStart = DAYS.between(LocalDate.now(), startDate);
            boolean cohortStarted = daysUntilCohortStart < 0;
            model.addAttribute("daysUntilCohortStart", daysUntilCohortStart);
            model.addAttribute("cohortStarted", cohortStarted);

        List<Student> students = currentCohort.getStudents();
            model.addAttribute("studentsAssigned", students);
            model.addAttribute("studentCount", students.size());

        return "/users/cohortProfile";
    }
}

