package ua.goit.model.dto;

public class SyntaxDevsListDto {

    private String name;
    private String syntax;


    public SyntaxDevsListDto(String name, String syntax) {
        this.name = name;
        this.syntax = syntax;
    }

    public SyntaxDevsListDto() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSyntax() {
        return syntax;
    }

    public void setSyntax(String syntax) {
        this.syntax = syntax;
    }

    @Override
    public String toString() {
        return "*** " +
                "Dev's name='" + name + '\'' +
                ", syntax='" + syntax + '\'' +
                " ***\n";
    }
}

