package com.codeup.studentdashboard.controllers;

import com.codeup.studentdashboard.dao.repository.CohortRepository;
import com.codeup.studentdashboard.dao.repository.HAUOptionsRepository;
import com.codeup.studentdashboard.dao.repository.PaymentOptionsRepository;
import com.codeup.studentdashboard.models.Student;
import com.codeup.studentdashboard.models.converters.StudentBillboardsConverter;
import com.codeup.studentdashboard.models.converters.StudentDescribeConverter;
import com.codeup.studentdashboard.models.enums.StudentBillboards;
import com.codeup.studentdashboard.models.enums.StudentDescribe;
import com.codeup.studentdashboard.models.enums.StudentGender;
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
    private final CohortRepository cohortRepository;
    private final PaymentOptionsRepository paymentOptionsRepository;
    private final HAUOptionsRepository hauOptionsRepository;

    public ApplicantController(CohortRepository cohortRepository,
                               PaymentOptionsRepository paymentOptionsRepository, HAUOptionsRepository hauOptionsRepository) {
        this.cohortRepository = cohortRepository;
        this.paymentOptionsRepository = paymentOptionsRepository;
        this.hauOptionsRepository = hauOptionsRepository;
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

        model.addAttribute("type", type);

        model.addAttribute("cohorts", cohortRepository.findAll());

        List<String> genderOptions = new ArrayList<>(StudentGender.values().length);
        for (StudentGender g : StudentGender.values()) {
            genderOptions.add(g.toString());
        }

        model.addAttribute("genderOptions", genderOptions);

        model.addAttribute("paymentOptions", paymentOptionsRepository.findAll());

        List<String> billboardOptions = new ArrayList<>(StudentBillboards.values().length);
        for (StudentBillboards b : StudentBillboards.values()) {
            billboardOptions.add(new StudentBillboardsConverter().convertToDatabaseColumn(b));
        }

        model.addAttribute("billboardOptions", billboardOptions);

        model.addAttribute("hauOptions", hauOptionsRepository.findAll());

        List<String> describes = new ArrayList<>(StudentDescribe.values().length);
        for (StudentDescribe d : StudentDescribe.values()) {
            describes.add(new StudentDescribeConverter().convertToDatabaseColumn(d));
        }

        model.addAttribute("describes", describes);

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
