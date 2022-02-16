package ua.goit.model.dto;

public class DevelopersDto {
    private Integer id;
    private String name;
    private String sex;
    private Double salary;

    public DevelopersDto(Integer id, String name, String sex, Double salary) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.salary = salary;
    }

    public DevelopersDto() {
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
}
