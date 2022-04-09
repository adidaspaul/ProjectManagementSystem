package ua.goit.model.dto;

public class SpecificProjectDevDto {

    private String name;
    private String projectName;

    public SpecificProjectDevDto(String name, String projectName) {
        this.name = name;
        this.projectName = projectName;
    }

    public SpecificProjectDevDto() {

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

    @Override
    public String toString() {
        return "*** " +
                "Dev's name='" + name + '\'' +
                ", projectName='" + projectName + '\'' +
                " ***\n";
    }
}
