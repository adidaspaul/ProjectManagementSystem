package ua.goit.model.dto;

public class ProjectDevsSalarySumDto {

    private String projectName;
    private Integer sum;

    public ProjectDevsSalarySumDto() {
    }

    public ProjectDevsSalarySumDto(String projectName, Integer sum) {
        this.projectName = projectName;
        this.sum = sum;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }
    @Override
    public String toString() {
        return "SPECIFIC PROJECT SALARY SUM ***" +
                "projectName--> '" + projectName + '\'' +
                ", sum--> " + sum +
                "***";
    }
}
