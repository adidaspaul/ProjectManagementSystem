package ua.goit.model.dto;

public class CompaniesDto {

    private Integer id;
    private String companyName;
    private String city;

    public CompaniesDto(Integer id, String companyName, String city) {
        this.id = id;
        this.companyName = companyName;
        this.city = city;
    }

    public CompaniesDto(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


}
