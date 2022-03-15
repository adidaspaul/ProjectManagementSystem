package ua.goit.model.dao;

import java.util.Objects;

public class ProjectsDao {

    private Integer id;
    private String projectName;
    private Double worth;

    public ProjectsDao() {
    }

    public ProjectsDao(Integer id, String projectName, Double worth) {
        this.id = id;
        this.projectName = projectName;
        this.worth = worth;
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

    public Double getWorth() {
        return worth;
    }

    public void setWorth(Double worth) {
        this.worth = worth;
    }

    @Override
    public String toString() {
        return "ProjectsDao{" +
                "id=" + id +
                ", projectName='" + projectName + '\'' +
                ", worth=" + worth +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectsDao that = (ProjectsDao) o;
        return projectName.equals(that.projectName) && worth.equals(that.worth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(projectName, worth);
    }

}
