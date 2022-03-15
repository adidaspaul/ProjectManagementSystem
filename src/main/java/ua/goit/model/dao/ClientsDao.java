package ua.goit.model.dao;

import java.util.Objects;

public class ClientsDao {

    private Integer id;
    private String name;
    private String country;
    private String category;

    public ClientsDao(Integer id, String name, String country, String category) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.category = category;
    }

    public ClientsDao(){}

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

    @Override
    public String toString() {
        return "ClientsDao{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", category='" + category + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientsDao that = (ClientsDao) o;
        return category.equals(that.category) && country.equals(that.country) && name.equals(that.name);
    }

    @Override
    public int hashCode(){
        return Objects.hash(name, country, category);
    }
}
