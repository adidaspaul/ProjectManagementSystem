package ua.goit.model.dao;

public class CompanyDevsDao {
    private Integer devId;
    private Integer companyId;

    public CompanyDevsDao(Integer devId, Integer companyId) {
        this.companyId = companyId;
        this.devId = devId;
    }

    public CompanyDevsDao() {
    }

    public Integer getDevId() {
        return devId;
    }

    public void setDevId(Integer devId) {
        this.devId = devId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

}
