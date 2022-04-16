package ua.goit.config;

import java.sql.Connection;
import java.sql.SQLException;


public interface DataBaseManagerConnector {

    Connection getConnection() throws SQLException;



}
