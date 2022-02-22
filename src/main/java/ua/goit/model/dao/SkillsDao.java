package ua.goit.model.dao;

import java.util.Arrays;
import java.util.Objects;

public class SkillsDao {

    private Integer id;
    private String rank;
    private String[] skills;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String[] getSkills() {
        return Arrays.toString(skills).replaceAll("[\\[\\]]", "").split(", ");
    }

    public void setSkills(String[] skills) {
        this.skills = skills;
    }

    @Override
    public String toString() {
        return "SkillsDao{" +
                "id=" + id +
                ", rank='" + rank + '\'' +
                ", skills=" + Arrays.toString(skills) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SkillsDao that = (SkillsDao) o;
        return Objects.equals(rank, that.rank) && Arrays.equals(skills, that.skills);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rank, Arrays.hashCode(skills));
    }
}
