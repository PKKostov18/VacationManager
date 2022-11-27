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
    User loggedUser;

    private static UserController userController;
    public static UserController getInstance() {
        if (userController == null) {
            userController = new  UserController();
        }
        return userController;
    }

    @GetMapping("/")
    public String indexPage() {
        return "index";
    }

    @GetMapping("/goToLoginPage")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/goToRegisterPage")
    public String registerPage() {
        return "register";
    }

    @GetMapping("/goToVacationRequestsPage")
    public String vacationRequestsPage() {
        return "vacationRequests";
    }

    @GetMapping("/unassignedPage")
    public String unassignedPage(Model model) {
        model.addAttribute("getLoggedUser", loggedUser);
        return "unassignedPage";
    }

    @GetMapping("/ceoPage")
    public String ceoPage(Model model) {
        model.addAttribute("getLoggedUser", loggedUser);
        return "ceoPage";
    }

    @GetMapping("/logout")
    public String logOut() {
        loggedUser = null;
        return "index";
    }

    @PostMapping("/register")
    public String addUser(@ModelAttribute User user) {
        userRepo.save(user);
        return "index";
    }

    @RequestMapping(value = "/usersInfo")
    public String getAllUsers(Model model) {
        model.addAttribute("users", userRepo.findAll());
        return "usersInfo";
    }

    @GetMapping(value="/login")
    public String getUserByUsernameAndPassword(@ModelAttribute User user, Model model) {
        loggedUser = userRepo.findByNicknameAndPassword(user.getNickname(), user.getPassword());
        model.addAttribute("getLoggedUser", loggedUser);

        if(loggedUser.getRole().contains("CEO")) {
            return "ceoPage";
        }
        else if(loggedUser.getRole().contains("Developer")) {
            return "developerPage";
        }
        else if(loggedUser.getRole().contains("Team Leader")) {
            return "teamLeaderPage";
        }

        return "unassignedPage";
    }
}
