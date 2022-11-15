package com.pkkostov18.vacationmanager.model;

import javax.persistence.*;

@Entity
@Table(name = "Projects")
public class Project {

    @Id
    @GeneratedValue
    private int projectId;
    @Column
    private String projectName;

    public Project(int projectId, String projectName) {
        this.projectId = projectId;
        this.projectName = projectName;
    }

    public Project() {

    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectId=" + projectId +
                ", projectName='" + projectName + '\'' +
                '}';
    }
}
