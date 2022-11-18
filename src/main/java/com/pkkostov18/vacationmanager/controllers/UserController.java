package com.pkkostov18.vacationmanager.controllers;

import com.pkkostov18.vacationmanager.dao.UserRepository;
import com.pkkostov18.vacationmanager.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    UserRepository userRepo;

    @GetMapping("/")
    public String index() {

        return "index";
    }

    @GetMapping("/register")
    public String register() {

        return "register";
    }

    @GetMapping("/login")
    public String getAllUsers() {
       return "login";
    }

    @PostMapping("/register")
    public String addUser(@ModelAttribute User user, Model model) {
        User registeredUser = userRepo.save(user);
        model.addAttribute("getRegisteredUser", registeredUser);
        return "welcome";
    }

}
