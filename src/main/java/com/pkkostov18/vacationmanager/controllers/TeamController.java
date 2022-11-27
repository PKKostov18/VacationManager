package com.pkkostov18.vacationmanager.controllers;

import com.pkkostov18.vacationmanager.dao.TeamRepository;
import com.pkkostov18.vacationmanager.dao.UserRepository;
import com.pkkostov18.vacationmanager.dao.UserTeamProjectRepository;
import com.pkkostov18.vacationmanager.model.Team;
import com.pkkostov18.vacationmanager.model.User;
import com.pkkostov18.vacationmanager.model.UserTeamProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Controller
public class TeamController{

    @Autowired
    TeamRepository teamRepository;
    @Autowired
    UserTeamProjectRepository userTeamProjectRepository;
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
    public String createTeam(@ModelAttribute Team team, Model model, UserTeamProject userTeamProject) {
        teamRepository.save(team);
        Team updatedTeam = teamRepository.findById(team.getTeamId()).get();
        updatedTeam.setTeamLeaderId(userController.loggedUser.getUserId());
        teamRepository.save(updatedTeam);
        User updatedUser = userController.loggedUser;
        updatedUser.setRole("Team Leader");
        userController.userRepo.save(updatedUser);
        model.addAttribute("getLoggedUser", updatedUser);
        userTeamProjectRepository.save(userTeamProject);
        UserTeamProject updatedUserTeamProject = userTeamProjectRepository.findById(userTeamProject.getId()).get();
        updatedUserTeamProject.setTeam(team);
        updatedUserTeamProject.setUser(userController.loggedUser);
        userTeamProjectRepository.save(updatedUserTeamProject);
        return "unassignedPage";
    }

    @RequestMapping(value = "/teamsInfo")
    public String getAllTeams(Model model) {
        model.addAttribute("teams", userTeamProjectRepository.findAll());
        return "teamsInfo";
    }
}
