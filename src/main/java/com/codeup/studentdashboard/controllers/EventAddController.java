package com.codeup.studentdashboard.controllers;

import com.codeup.studentdashboard.dao.repository.EventRepository;
import com.codeup.studentdashboard.dao.repository.EventTypeRepository;
import com.codeup.studentdashboard.dao.repository.StudentRepository;
import com.codeup.studentdashboard.dao.repository.UserRepository;
import com.codeup.studentdashboard.models.EventType;
import com.codeup.studentdashboard.models.Events;
import com.codeup.studentdashboard.models.Student;
import com.codeup.studentdashboard.models.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.websocket.Session;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import static java.lang.Integer.parseInt;

@Controller
@SessionAttributes("eventData")
public class EventAddController {

    private final EventRepository eventRepository;
    private final EventTypeRepository eventTypeRepository;
    private final UserRepository userRepository;
    private final StudentRepository studentRepository;

    public EventAddController(EventRepository eventRepository, UserRepository userRepository, EventTypeRepository eventTypeRepository, StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
        this.eventRepository = eventRepository;
        this.userRepository = userRepository;
        this.eventTypeRepository = eventTypeRepository;
    }

    @GetMapping("/users/addEvent/{id}")
    public String studentEventAdd(@PathVariable String id, Model model) {
        model.addAttribute("event", new Events());
        Long idNumber = Long.parseLong(id);

        model.addAttribute("student", studentRepository.findById(idNumber));
        model.addAttribute("eventTypes", eventTypeRepository.findAll());

        return "/users/addEvent";

    }
    @PostMapping("/users/addEvent")
    public String create(@ModelAttribute Events event, Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        Long et = event.getId();
//        EventType eType = event.getType();
//        event.setType(eventTypeRepository.findOne(eType.getId()));
        event.setUser(userRepository.findOne(user.getId()));
        eventRepository.save(event);

        Student curStudent = event.getStudent();
        model.addAttribute("student", curStudent);

        return "redirect:/users/studentEvents/" + curStudent.getId();
    }
}