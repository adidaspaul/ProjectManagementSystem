package ua.goit.model.dao;

public class ProjectDevsSalarySumDao {

    private String projectName;
    private Integer sum;

    public ProjectDevsSalarySumDao(String projectName, Integer sum) {
        this.projectName = projectName;
        this.sum = sum;
    }
    public ProjectDevsSalarySumDao() {

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


}
