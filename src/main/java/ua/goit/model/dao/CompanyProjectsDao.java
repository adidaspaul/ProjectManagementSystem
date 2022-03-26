package ua.goit.model.dao;

public class CompanyProjectsDao {

    private Integer projectId;
    private Integer companyId;

    public CompanyProjectsDao(Integer projectId, Integer companyId) {
        this.companyId = companyId;
        this.projectId = projectId;
    }

    public CompanyProjectsDao() {
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }
}
