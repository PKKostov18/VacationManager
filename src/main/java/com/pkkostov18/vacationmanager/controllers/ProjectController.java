package com.pkkostov18.vacationmanager.controllers;

import com.pkkostov18.vacationmanager.dao.ProjectRepository;
import com.pkkostov18.vacationmanager.dao.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProjectController {

    @Autowired
    ProjectRepository projectRepository;

    @GetMapping("/goToProjectsInfoPage")
    public String projectsInfoPage() {
        return "projectsInfo";
    }
}
