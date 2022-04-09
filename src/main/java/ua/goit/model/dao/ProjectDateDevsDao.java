package ua.goit.model.dao;

import java.sql.Date;

public class ProjectDateDevsDao {

    private Date startDate;
    private String projectName;
    private Integer count;

    public ProjectDateDevsDao(Date startDate, String projectName, Integer count){
        this.startDate = startDate;
        this.projectName = projectName;
        this.count = count;
    }

    public ProjectDateDevsDao() {

    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
