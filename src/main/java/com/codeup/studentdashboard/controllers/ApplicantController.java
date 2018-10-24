package com.codeup.studentdashboard.controllers;

import com.codeup.studentdashboard.models.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("applicantData")
public class ApplicantController {

    @GetMapping("/apply")
    public String apply(@RequestParam(value = "t", required = false) String type, Model model, @ModelAttribute("applicantData") ApplicantData applicantData) {
        if (applicantData == null) {
            applicantData = new ApplicantData();
            model.addAttribute("applicantData", applicantData);
        }

        model.addAttribute("type", type);

        return "apply";
    }

    @ModelAttribute("applicantData")
    public ApplicantData applicantData() {
        return new ApplicantData();
    }

    private class ApplicantData extends Student {
        ApplicantData() {}
    }
}
