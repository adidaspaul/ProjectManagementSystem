package ua.goit.model.dto;

import ua.goit.model.dao.SkillsDao;

import java.util.Objects;

public class SkillsDto {

    private Integer id;
    private String rank;
    private String syntax;

    public SkillsDto(Integer id, String rank, String syntax) {
        this.id = id;
        this.rank = rank;
        this.syntax = syntax;
    }

    public SkillsDto() {
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
        return "SkillsDto{" +
                "id=" + id +
                ", rank='" + rank + '\'' +
                ", skills=" + syntax +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SkillsDto that = (SkillsDto) o;
        return Objects.equals(rank, that.rank) && Objects.equals(syntax, that.syntax);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rank, syntax);
    }
}



