package ua.goit.model.dto;

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
}



