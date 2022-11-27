package com.pkkostov18.vacationmanager.model;

import com.pkkostov18.vacationmanager.controllers.UserController;

import javax.persistence.*;

@Entity
@Table(name = "Teams")
public class Team {

    @Id
    @GeneratedValue
    private int teamId;
    @Column
    private String teamName;
    @Column
    private int teamLeaderId;

    public Team(int teamId, String teamName, int teamLeaderId) {
        this.teamId = teamId;
        this.teamName = teamName;
        this.teamLeaderId = teamLeaderId;
    }

    public Team() {

    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getTeamLeaderId() {
        return teamLeaderId;
    }

    public void setTeamLeaderId(int teamLeaderId) {
        this.teamLeaderId = teamLeaderId;
    }

    @Override
    public String toString() {
        return "Team{" +
                "teamId=" + teamId +
                ", teamName='" + teamName + '\'' +
                ", teamLeaderId=" + teamLeaderId +
                '}';
    }
}
