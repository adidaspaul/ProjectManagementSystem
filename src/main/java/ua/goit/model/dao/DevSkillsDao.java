package ua.goit.model.dao;

public class DevSkillsDao {

    private Integer devId;
    private Integer skillId;

    public DevSkillsDao(Integer skillsId, Integer developersId) {
        this.skillId = skillsId;
        this.devId = developersId;
    }

    public DevSkillsDao() {
    }

    public Integer getDev_id() {
        return devId;
    }

    public void setDev_id(Integer devId) {
        this.devId = devId;
    }

    public Integer getSkillId() {
        return skillId;
    }

    public void setSkillId(Integer skillId) {
        this.skillId = skillId;
    }
}
