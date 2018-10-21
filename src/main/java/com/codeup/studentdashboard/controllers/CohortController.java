package com.codeup.studentdashboard.controllers;

import com.codeup.studentdashboard.dao.repository.CohortRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CohortController {

    private final CohortRepository cohortRepository;

    public CohortController(CohortRepository cohortRepository) {
        this.cohortRepository = cohortRepository;
    }

    @GetMapping("/users/cohorts")
    public String cohort(Model model) {
        model.addAttribute("cohorts", cohortRepository.findAll());
        return "/users/cohorts";
    }
}
