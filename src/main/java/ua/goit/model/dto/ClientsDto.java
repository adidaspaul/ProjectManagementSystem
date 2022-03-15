package ua.goit.model.dto;

public class ClientsDto {
    private Integer id;
    private String name;
    private String country;
    private String category;

    public ClientsDto(Integer id, String name, String country, String category) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.category = category;
    }

    public ClientsDto(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
