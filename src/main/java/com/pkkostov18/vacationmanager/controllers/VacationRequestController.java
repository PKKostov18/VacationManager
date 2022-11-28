package com.pkkostov18.vacationmanager.controllers;

import com.pkkostov18.vacationmanager.dao.VacationRequestRepository;
import com.pkkostov18.vacationmanager.model.Team;
import com.pkkostov18.vacationmanager.model.User;
import com.pkkostov18.vacationmanager.model.UserTeamProject;
import com.pkkostov18.vacationmanager.model.VacationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Optional;

@Controller
public class VacationRequestController {

    @Autowired
    VacationRequestRepository vacationRequestRepository;
    @Autowired
    UserController userController = UserController.getInstance();

    @GetMapping("/goTovacationRequestPage")
    public String vacationRequestPage() {
        return "vacationRequests";
    }

    @PostMapping("/createVacationRequest")
    public String makeVacationRequest(@ModelAttribute VacationRequest vacationRequest, Model model) {

        vacationRequestRepository.saveAndFlush(vacationRequest);
        VacationRequest updatedVacationRequest = vacationRequestRepository.findById(vacationRequest.getId()).get();
        updatedVacationRequest.setCreationDate(new Date());
        updatedVacationRequest.setUserId(userController.loggedUser.getUserId());
        vacationRequestRepository.saveAndFlush(updatedVacationRequest);
        model.addAttribute("getLoggedUser", userController.loggedUser);
        if(userController.loggedUser.getRole().contains("Developer")) {
            return "developerPage";
        }
        else if(userController.loggedUser.getRole().contains("Team Leader")) {
            return "teamLeaderPage";
        }

        return "ceoPage";
    }


}
