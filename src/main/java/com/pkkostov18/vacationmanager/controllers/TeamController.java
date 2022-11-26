package com.pkkostov18.vacationmanager.controllers;

import com.pkkostov18.vacationmanager.dao.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TeamController {

    @Autowired
    TeamRepository teamRepository;

    @GetMapping("/goToTeamsInfoPage")
    public String teamsInfoPage() {
        return "teamsInfo";
    }
}
