package ua.goit;

import ua.goit.config.DataBaseManagerConnector;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        DataBaseManagerConnector connector = new DataBaseManagerConnector("localhost", 5432, "postgres",
                "postgres", "19902007");
        try {
            Connection connect = connector.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
