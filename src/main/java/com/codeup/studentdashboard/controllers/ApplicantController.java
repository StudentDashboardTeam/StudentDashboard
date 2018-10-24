package com.codeup.studentdashboard.controllers;

import com.codeup.studentdashboard.dao.repository.PaymentOptionsRepository;
import com.codeup.studentdashboard.models.Student;
import com.codeup.studentdashboard.models.converters.StudentGenderConverter;
import com.codeup.studentdashboard.models.enums.StudentGender;
import com.codeup.studentdashboard.models.student.PaymentOption;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes("applicantData")
public class ApplicantController {
    private final PaymentOptionsRepository paymentOptionsRepository;

    public ApplicantController(PaymentOptionsRepository paymentOptionsRepository) {
        this.paymentOptionsRepository = paymentOptionsRepository;
    }

    @GetMapping("/apply")
    public String apply(Model model, @ModelAttribute("applicantData") ApplicantData applicantData) {
        if (applicantData == null) {
            applicantData = new ApplicantData();
            model.addAttribute("applicantData", applicantData);
        }

        return "/apply/apply";
    }

    @GetMapping(value = "/apply", params = "t")
    public String applyWeb(@RequestParam(value = "t", required = false) String type, Model model, @ModelAttribute("applicantData") ApplicantData applicantData) {
        if (applicantData == null) {
            applicantData = new ApplicantData();
            model.addAttribute("applicantData", applicantData);
        }

        List<String> genderOptions = new ArrayList<>(StudentGender.values().length);
        for (StudentGender g : StudentGender.values()) {
            genderOptions.add(g.toString());
        }

        model.addAttribute("genderOptions", genderOptions);

        model.addAttribute("paymentOptions", paymentOptionsRepository.findAll());

        switch (type) {
            case "web":
                return "/apply/web";
            case "data":
                return "/apply/data";
            default:
                return "/apply/apply";
        }
    }

    @ModelAttribute("applicantData")
    public ApplicantData applicantData() {
        return new ApplicantData();
    }

    private class ApplicantData extends Student {
        ApplicantData() {}
    }
}
