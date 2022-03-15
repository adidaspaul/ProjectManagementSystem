package ua.goit.model.dao;

import java.util.Objects;

public class CompaniesDao {

    private Integer id;
    private String companyName;
    private String city;

    public CompaniesDao(Integer id, String companyName, String city) {
        this.id = id;
        this.companyName = companyName;
        this.city = city;
    }

    public CompaniesDao(){}

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

    @Override
    public String toString() {
        return "CompaniesDao{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CompaniesDao that = (CompaniesDao) o;
        return companyName.equals(that.companyName) && city.equals(that.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(companyName, city);
    }

}
