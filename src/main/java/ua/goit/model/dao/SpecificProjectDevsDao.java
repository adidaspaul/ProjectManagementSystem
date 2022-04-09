package ua.goit.model.dao;

public class SpecificProjectDevsDao {

    private String name;
    private String projectName;


    public SpecificProjectDevsDao(String name, String projectName) {
        this.name = name;
        this.projectName = projectName;
    }

    public SpecificProjectDevsDao() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
}
