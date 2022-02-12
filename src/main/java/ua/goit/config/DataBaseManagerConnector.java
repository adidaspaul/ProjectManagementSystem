package ua.goit.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class DataBaseManagerConnector {

    private final Properties PROPS;
    private final String URL;



    public DataBaseManagerConnector(String hostname, int port, String database, String username, String password) {
        URL = String.format("jdbc:postgresql://%s:%d/%s", hostname, port, database);
        PROPS = new Properties();
        PROPS.setProperty("user", username);
        PROPS.setProperty("password", password);
    }
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, PROPS);
    }

}
