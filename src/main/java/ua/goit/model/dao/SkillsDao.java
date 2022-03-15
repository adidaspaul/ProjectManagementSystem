package ua.goit.model.dao;

import java.util.Objects;

public class SkillsDao {

    private Integer id;
    private String rank;
    private String syntax;

    public SkillsDao() {
    }

    public SkillsDao(Integer id, String rank, String syntax) {
        this.id = id;
        this.rank = rank;
        this.syntax = syntax;
    }

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

    public String getSyntax() {
        return syntax;
    }

    public void setSyntax(String syntax) {
        this.syntax = syntax;
    }

    @Override
    public String toString() {
        return "SkillsDao{" +
                "id=" + id +
                ", rank='" + rank + '\'' +
                ", skills=" + syntax +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SkillsDao that = (SkillsDao) o;
        return Objects.equals(rank, that.rank) && Objects.equals(syntax, that.syntax);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rank, syntax);
    }
}
