package com.codeup.studentdashboard.controllers;

//import com.codeup.studentdashboard.dao.repository.PaymentOptionsRepository;
import com.codeup.studentdashboard.dao.repository.StudentRepository;
import com.codeup.studentdashboard.models.Cohort;
import com.codeup.studentdashboard.models.Student;
import com.codeup.studentdashboard.models.converters.StudentBillboardsConverter;
import com.codeup.studentdashboard.models.converters.StudentDescribeConverter;
import com.codeup.studentdashboard.models.converters.StudentGenderConverter;
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
        if (studentCohort != null)
            model.addAttribute("cohort", studentCohort.toString());
        else
            model.addAttribute("cohort",  null);

        // GRAB PAYMENT OPTIONS
//        PaymentOption po = currentStudent.getPaymentOption();
//            model.addAttribute("selfPay", po.isself());
//            model.addAttribute("va", po.isva());
//            model.addAttribute("loan", po.isloan());
//            model.addAttribute("scholarship", po.isscholarship());
//            model.addAttribute("other", po.isother());

        // GRAB GENDER
        String gender = new StudentGenderConverter().convertToDatabaseColumn(currentStudent.getGender());

        model.addAttribute("gender", gender);

        // GRAB BILLBOARDS
        String billboard = new StudentBillboardsConverter().convertToDatabaseColumn(currentStudent.getBillboards());

        model.addAttribute("billboard", billboard);

        // GRAB DESCRIPTION OF SELF
        String description = new StudentDescribeConverter().convertToDatabaseColumn(currentStudent.getDescribe());

        model.addAttribute("description", description);

        // GRAB 'HOW THEY HEARD ABOUT CODEUP'
//        HearAboutUs heard = currentStudent.getHearAboutUs();
//            model.addAttribute("socMedia", heard.istwitterFacebook());
//            model.addAttribute("youtube", heard.isyoutube());
//            model.addAttribute("muse", heard.ismuse());
//            model.addAttribute("billboard", heard.isbillboard());
//            model.addAttribute("tv", heard.istv());
//            model.addAttribute("radio", heard.isradio());
//            model.addAttribute("news", heard.isnews());
//            model.addAttribute("web", heard.isweb());
//            model.addAttribute("geekdom", heard.isgeekdom());
//            model.addAttribute("friend", heard.isfriendFamily());
//            model.addAttribute("employer", heard.isemployer());
//            model.addAttribute("codeupStudent", heard.isstudent());
//            model.addAttribute("jobFair", heard.isjobSchoolFair());
//            model.addAttribute("otherHeard", heard.isother());

                return "/users/studentProfile";
    }
}