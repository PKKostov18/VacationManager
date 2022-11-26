package com.pkkostov18.vacationmanager.dao;

import com.pkkostov18.vacationmanager.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, String> {


}
