package com.pkkostov18.vacationmanager.controllers;

import com.pkkostov18.vacationmanager.dao.VacationRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class VacationRequestController {

    @Autowired
    VacationRequestRepository vacationRequestRepository;


}
