package com.codeup.studentdashboard.controllers;

//import com.codeup.studentdashboard.dao.repository.PaymentOptionsRepository;
import com.codeup.studentdashboard.dao.repository.StudentRepository;
import com.codeup.studentdashboard.models.Cohort;
import com.codeup.studentdashboard.models.Student;
import com.codeup.studentdashboard.models.enums.StudentDescribe;
import com.codeup.studentdashboard.models.student.HearAboutUs;
import com.codeup.studentdashboard.models.student.PaymentOptions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
        model.addAttribute("cohort", studentCohort.toString());

        // GRAB PAYMENT OPTIONS
        PaymentOptions po = currentStudent.getPaymentOptions();
            model.addAttribute("selfPay", po.isself());
            model.addAttribute("va", po.isva());
            model.addAttribute("loan", po.isloan());
            model.addAttribute("scholarship", po.isscholarship());
            model.addAttribute("other", po.isother());

        // GRAB DESCRIPTION OF SELF
        StudentDescribe sd = currentStudent.getDescribe();
            String desc = sd.toString();
            String description = "";

        if (desc.equalsIgnoreCase("VET_MIL")) {
            description = "Transitioning Veteran or Active Military";
        } else if (desc.equalsIgnoreCase("SERVICE")) {
            description = "Currently works in the service industry and is looking for change";
        } else if (desc.equalsIgnoreCase("SAME")) {
            description = "Has been in the same career for five years and is looking for change";
        } else if (desc.equalsIgnoreCase("COLLEGE")) {
            description = "College student or graduate looking for a more hands-on learning experience";
        } else if (desc.equalsIgnoreCase("HS")) {
            description = "Recent high school graduate and looking for alternative options to college/university";
        }
            model.addAttribute("description", description);

        // GRAB 'HOW THEY HEARD ABOUT CODEUP'
        HearAboutUs heard = currentStudent.getHearAboutUs();
            model.addAttribute("socMedia", heard.istwitterFacebook());
            model.addAttribute("youtube", heard.isyoutube());
            model.addAttribute("muse", heard.ismuse());
            model.addAttribute("billboard", heard.isbillboard());
            model.addAttribute("tv", heard.istv());
            model.addAttribute("radio", heard.isradio());
            model.addAttribute("news", heard.isnews());
            model.addAttribute("web", heard.isweb());
            model.addAttribute("geekdom", heard.isgeekdom());
            model.addAttribute("friend", heard.isfriendFamily());
            model.addAttribute("employer", heard.isemployer());
            model.addAttribute("codeupStudent", heard.isstudent());
            model.addAttribute("jobFair", heard.isjobSchoolFair());
            model.addAttribute("otherHeard", heard.isother());

                return "/users/studentProfile";
    }
}