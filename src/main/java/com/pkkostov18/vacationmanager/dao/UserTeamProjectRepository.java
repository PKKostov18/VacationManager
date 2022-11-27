package com.pkkostov18.vacationmanager.dao;

import com.pkkostov18.vacationmanager.model.UserTeamProject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserTeamProjectRepository extends JpaRepository<UserTeamProject, Integer> {
    UserTeamProject findUserByTeamTeamLeaderId(int id);
}
