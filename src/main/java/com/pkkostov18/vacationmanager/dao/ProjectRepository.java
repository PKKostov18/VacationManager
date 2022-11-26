package com.pkkostov18.vacationmanager.dao;

import com.pkkostov18.vacationmanager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<User, String> {


}
