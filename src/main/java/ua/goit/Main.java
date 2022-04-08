package ua.goit;

import ua.goit.config.DataBaseManagerConnector;
import ua.goit.config.PropertiesUtil;
import ua.goit.dl.DevelopersRepository;
import ua.goit.dl.Repository;
import ua.goit.model.converter.DevelopersConverter;
import ua.goit.model.converter.SumConverter;
import ua.goit.model.dao.DevelopersDao;
import ua.goit.model.dto.DevelopersDto;
import ua.goit.service.DevelopersService;
import ua.goit.service.ProjectSalarySumService;

import java.util.List;
import java.util.stream.Collectors;
//import ua.goit.model.dao.ProjectsDao;
//import ua.goit.model.dao.SkillDao;
//import ua.goit.model.dao.SkillDevelopersDao;


public class Main {
    public static void main(String[] args) {
        PropertiesUtil util = new PropertiesUtil();
        DevelopersConverter converter = new DevelopersConverter();
        SumConverter sumConverter = new SumConverter();
        DataBaseManagerConnector connector = new DataBaseManagerConnector(util.getHostname(),
                util.getPort(),
                util.getSchema(),
                util.getUser(),
                util.getPassword());

        //ВЫБРАТЬ СУММУ ЗАРПЛАТ ВСЕХ РАЗРАБОТЧИКОВ ПО ОТДЕЛЬНОМУ ПРОЕКТУ И ВЫВЕСТИ В КОНСОЛЬ
        ProjectSalarySumService salarySumService = new ProjectSalarySumService(sumConverter,connector);
        System.out.println(salarySumService.getProjectSalarySumById(1));




//       Repository<DevelopersDao> devRep = new DevelopersRepository(connector);
//       DevelopersConverter converter1 = new DevelopersConverter();
//        DevelopersService service = new DevelopersService(converter, devRep);
//        DevelopersDto dto = service.findById(12);
//       System.out.println(dto);
//       List<DevelopersDao> devId = devRep.selectAll();
//       devId.stream().forEach(System.out::println);
//        System.out.println(devId.getName());
//        System.out.println(devId.getSex());
//        System.out.println(devId.getSalary());


//        DevelopersDao newDev = new DevelopersDao();
//        newDev.setId(18);
//        newDev.setName("Vasya");
//        newDev.setSex("male");
//        newDev.setSalary(3200.50);
//        devRep.saveWithId(newDev);
//        newDev.setName("Alina");
//        newDev.setSex("female");
//        newDev.setSalary(3500.00);


    }
}
