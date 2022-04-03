package ua.goit.model.dto;

import java.sql.Date;

public class ProjectsDto {
    private Integer id;
    private String projectName;
    private Date startDate;
    private Double cost;

    public ProjectsDto(Integer id, String projectName, Double cost, Date startDate) {
        this.id = id;
        this.projectName = projectName;
        this.startDate = startDate;
        this.cost = cost;
    }

    public ProjectsDto() {
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }


}
