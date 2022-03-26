package ua.goit.model.dao;

public class DevProjectsDao {
    private Integer devId;
    private Integer projectId;

    public DevProjectsDao(Integer skills_id, Integer developers_id) {
        this.projectId = skills_id;
        this.devId = developers_id;
    }

    public DevProjectsDao() {
    }

    public Integer getDevId() {
        return devId;
    }

    public void setDevId(Integer devId) {
        this.devId = devId;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

}
