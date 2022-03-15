package ua.goit.model.dto;

public class ProjectsDto {
    private Integer id;
    private String projectName;
    private Double cost;

    public ProjectsDto(Integer id, String projectName, Double cost) {
        this.id = id;
        this.projectName = projectName;
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

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }


}
