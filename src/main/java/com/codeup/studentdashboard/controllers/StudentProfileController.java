package com.codeup.studentdashboard.controllers;

//import com.codeup.studentdashboard.dao.repository.PaymentOptionsRepository;
import com.codeup.studentdashboard.dao.repository.StudentRepository;
import com.codeup.studentdashboard.models.Cohort;
import com.codeup.studentdashboard.models.Events;
import com.codeup.studentdashboard.models.Student;
import com.codeup.studentdashboard.models.converters.StudentBillboardsConverter;
import com.codeup.studentdashboard.models.converters.StudentDescribeConverter;
import com.codeup.studentdashboard.models.converters.StudentGenderConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class StudentProfileController {

    private final StudentRepository studentRepository;

    public StudentProfileController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/users/students/{id}")
    public String studentProfile(@PathVariable String id, Model model) {

        Long idNumber = Long.parseLong(id);
        Student currentStudent = studentRepository.findById(idNumber);
        model.addAttribute("student", currentStudent);

        Cohort studentCohort = currentStudent.getCohort();
        if (studentCohort != null)
            model.addAttribute("cohort", studentCohort.toString());
        else
            model.addAttribute("cohort",  null);

        // GRAB GENDER
        String gender = new StudentGenderConverter().convertToDatabaseColumn(currentStudent.getGender());

        model.addAttribute("gender", gender);

        // GRAB BILLBOARDS
        String billboard = new StudentBillboardsConverter().convertToDatabaseColumn(currentStudent.getBillboards());

        model.addAttribute("billboard", billboard);

        // GRAB DESCRIPTION OF SELF
        String description = new StudentDescribeConverter().convertToDatabaseColumn(currentStudent.getDescribe());

        model.addAttribute("description", description);

        // GRAB EVENTS

        List<Events> events = currentStudent.getEvents();

        model.addAttribute("events", events);

        return "/users/studentProfile";
    }
}
