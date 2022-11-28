package com.pkkostov18.vacationmanager.dao;

import com.pkkostov18.vacationmanager.model.VacationRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VacationRequestRepository extends JpaRepository<VacationRequest, Integer> {

}
