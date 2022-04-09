package ua.goit.model.dto;

import java.sql.Date;

public class ProjectDateDevsDto {

    private Date startDate;
    private String projectName;
    private Integer count;

    public ProjectDateDevsDto(Date startDate, String projectName, Integer count){
        this.startDate = startDate;
        this.projectName = projectName;
        this.count = count;
    }

    public ProjectDateDevsDto() {

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

    @Override
    public String toString() {
        return "*** " +
                "Project startDate=" + startDate +
                ", projectName='" + projectName + '\'' +
                ", project developers amount= " + count +
                " ***\n";
    }
}
