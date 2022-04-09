package ua.goit.model.dao;

public class SyntaxDevsListDao {

        private String name;
        private String syntax;


        public SyntaxDevsListDao(String name, String syntax) {
            this.name = name;
            this.syntax = syntax;
        }

        public SyntaxDevsListDao() {

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
    }

