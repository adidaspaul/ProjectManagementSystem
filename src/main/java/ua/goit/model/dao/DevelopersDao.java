package ua.goit.model.dao;

import java.util.Objects;

public class DevelopersDao {
    private Integer id;
    private String name;
    private String sex;
    private Double salary;

    public DevelopersDao(Integer id, String name, String sex, Double salary) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.salary = salary;
    }

    public DevelopersDao() {
    }

    public int getId() {
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString(){
        return "(id: " + id +
                ", name: " + name +
                ", sex: " + sex +
                ", salary:" + salary + ");";

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DevelopersDao that = (DevelopersDao) o;
        return name.equals(that.name) && sex.equals(that.sex) && salary.equals(that.salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, sex, salary);
    }
}


