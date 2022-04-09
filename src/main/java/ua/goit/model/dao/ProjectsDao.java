package ua.goit.model.dao;

import java.util.Objects;
import java.sql.Date;

public class ProjectsDao {

    private Integer id;
    private String projectName;
    private Date startDate;
    private Double cost;

    public ProjectsDao() {
    }

    public ProjectsDao(Integer id, String projectName, Date startDate, Double worth) {
        this.id = id;
        this.projectName = projectName;
        this.startDate = startDate;
        this.cost = worth;
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

    @Override
    public String toString() {
        return "ProjectsDao{" +
                "id=" + id +
                ", projectName='" + projectName + '\'' +
                ", worth=" + cost +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectsDao that = (ProjectsDao) o;
        return projectName.equals(that.projectName) && cost.equals(that.cost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(projectName, cost);
    }

}
