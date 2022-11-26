package com.pkkostov18.vacationmanager.controllers;

import com.pkkostov18.vacationmanager.dao.TeamRepository;
import com.pkkostov18.vacationmanager.dao.UserRepository;
import com.pkkostov18.vacationmanager.model.Team;
import com.pkkostov18.vacationmanager.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TeamController{

    @Autowired
    TeamRepository teamRepository;

    @Autowired
    UserController userController = UserController.getInstance();

    @GetMapping("/goToTeamsInfoPage")
    public String teamsInfoPage() {
        return "teamsInfo";
    }

    @GetMapping("/goToCreateTeamPage")
    public String createTeamPage() {
        return "createTeam";
    }

    @PostMapping("/createTeam")
    public String createTeam(@ModelAttribute Team team) {
        teamRepository.save(team);
        Team updatedTeam = teamRepository.findById(team.getTeamId()).get();
        updatedTeam.setTeamLeaderId(userController.loggedUser.getUserId());
        teamRepository.save(updatedTeam);
        User updatedUser = userController.loggedUser;
        updatedUser.setRole("Team Leader");
        userController.userRepo.save(updatedUser);
        return "unassignedPage";
    }
}
