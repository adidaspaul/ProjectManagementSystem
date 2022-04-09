package ua.goit.model.dto;

public class DevsRankListDto {
    private String name;
    private String rank;


    public DevsRankListDto(String name, String rank) {
        this.name = name;
        this.rank = rank;
    }

    public DevsRankListDto() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "*** " +
                "Dev's name='" + name + '\'' +
                ", rank='" + rank + '\'' +
                " ***\n";
    }
}
