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
        Repository<DevelopersDao> devRep = new DevelopersRepository(connector);
//        DevelopersDao devId = devRep.findById(36);
//        System.out.println(devId.getName());
//        System.out.println(devId.getSex());
//        System.out.println(devId.getSalary());


        DevelopersDao newDev = new DevelopersDao();
        newDev.setName("Alina");
        newDev.setSex("female");
        newDev.setSalary(3500.00);

        devRep.save(newDev);
    }
}
