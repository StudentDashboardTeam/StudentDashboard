package com.codeup.studentdashboard.controllers;

import com.codeup.studentdashboard.dao.repository.EventRepository;
import com.codeup.studentdashboard.dao.repository.UserRepository;
import com.codeup.studentdashboard.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes("eventData")
public class EventAddController {

    private final EventRepository eventRepository;
    private final UserRepository userRepository;

    public EventAddController(EventRepository eventRepository, UserRepository userRepository) {
        this.eventRepository = eventRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/users/addEvent/{id}")
    public String studentEventAdd(@PathVariable String id, Model model) {
        Long idNumber = Long.parseLong(id);

//        Iterable<User> users = userRepository.findAll();
        model.addAttribute("users", userRepository.findAll());

//        List<String> usernames = new ArrayList<>();
//        for (User u : users) {
//            usernames.add(u.getUsername());
//        }
//        model.addAttribute("users", usernames);

        return "/users/addEvent";


//        List<String> events = new ArrayList<>(eventRepository.);
//        for (Events g : .values()) {
//            genderOptions.add(g.toString());
//        }
        }
    }