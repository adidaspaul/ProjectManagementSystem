package ua.goit;

import ua.goit.config.DataBaseManagerConnector;
import ua.goit.config.PropertiesUtil;
import ua.goit.dl.DevelopersRepository;
import ua.goit.dl.Repository;
import ua.goit.model.dao.DevelopersDao;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        PropertiesUtil util = new PropertiesUtil();
        DataBaseManagerConnector connector = new DataBaseManagerConnector(util.getHostname(),
                util.getPort(),
                util.getSchema(),
                util.getUser(),
                util.getPassword());
        try {
            Connection connect = connector.getConnection();
            Repository<DevelopersDao> devRep = new DevelopersRepository(connect);
            DevelopersDao devId = devRep.findById(1);
            System.out.println(devId.getName());
            System.out.println(devId.getSex());
            System.out.println(devId.getSalary());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
