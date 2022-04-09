package ua.goit.model.dao;

public class DevsRankListDao {
    private String name;
    private String rank;


    public DevsRankListDao(String name, String rank) {
        this.name = name;
        this.rank = rank;
    }

    public DevsRankListDao() {

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
}

