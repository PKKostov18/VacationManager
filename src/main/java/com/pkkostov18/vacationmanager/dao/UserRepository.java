package com.pkkostov18.vacationmanager.dao;

import com.pkkostov18.vacationmanager.model.Team;
import com.pkkostov18.vacationmanager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

        User findByNicknameAndPassword(String username, String password);
}
