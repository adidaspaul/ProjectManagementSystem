package ua.goit.model.dao;

public class ClientProjectsDao {

    private Integer clientId;
    private Integer projectId;

    public ClientProjectsDao(Integer projectId, Integer clientId) {
        this.projectId = projectId;
        this.clientId = clientId;
    }

    public ClientProjectsDao() {
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

}
