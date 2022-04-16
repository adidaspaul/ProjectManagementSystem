package ua.goit;

import java.sql.Date;
import ua.goit.config.HikariProvider;
import ua.goit.config.PropertiesUtil;
import ua.goit.dl.*;
import ua.goit.model.converter.CompaniesConverter;
import ua.goit.model.converter.DevelopersConverter;
import ua.goit.model.converter.QueryConverter;
import ua.goit.model.dao.*;
import ua.goit.model.dto.CompaniesDto;
import ua.goit.model.dto.DevelopersDto;
import ua.goit.service.CompaniesService;
import ua.goit.service.DevelopersService;
import ua.goit.service.QueiriesService;
import ua.goit.model.dao.ProjectsDao;
import ua.goit.model.dao.SkillsDao;


public class Main {
    public static void main(String[] args) {
        PropertiesUtil util = new PropertiesUtil();
        DevelopersConverter devConverter = new DevelopersConverter();
        QueryConverter sumConverter = new QueryConverter();
        CompaniesConverter compConverter = new CompaniesConverter();
        HikariProvider connector = new HikariProvider(util.getHostname(),
                util.getPort(),
                util.getSchema(),
                util.getUser(),
                util.getPassword());

//        SELECT AND PRINT OUT SALARY SUM OF DEVELOPERS ON THE SPECIFIC PROJECT
        QueiriesService salarySumService = new QueiriesService(sumConverter,connector);
        System.out.println(salarySumService.getProjectSalarySumById(1));


        //SELECT AND PRINT ON CONSOLE LIST OF DEVELOPERS OF A SPECIFIC PROJECT
        QueiriesService developersList = new QueiriesService(sumConverter,connector);
        System.out.println(developersList.listOfSpecificProjectDev(2));

        //SELECT AND PRINT ON CONSOLE LIST OF DEVELOPERS BY SPECIFIC SYNTAX
        QueiriesService developersListBySyntax = new QueiriesService(sumConverter,connector);
        System.out.println(developersListBySyntax.listOfDevSyntax("Java"));

       //SELECT AND PRINT ON CONSOLE LIST OF DEVELOPERS BY SPECIFIC RANK
       QueiriesService developersListByRank = new QueiriesService(sumConverter,connector);
        System.out.println(developersListByRank.listOfDevsRank("Middle"));

       //SELECT AND PRINT ON CONSOLE LIST OF PROJECTS WITH DATE AND AMOUNT OF DEVELOPERS
       QueiriesService projectsList = new QueiriesService(sumConverter,connector);
        System.out.println(projectsList.listProjectDateDevs());


        //SAVE NEW DEVELOPER
        Repository<DevelopersDao> devRep = new DevelopersRepository(connector);
        DevelopersService devService = new DevelopersService(devConverter,devRep);
        DevelopersDto dev = new DevelopersDto();
        dev.setId(18);
        dev.setName("Zelenskiy");
        dev.setSex("male");
        dev.setSalary(5000d);
        devService.save(dev);

        //SAVE NEW COMPANY
        Repository<CompaniesDao> compRep = new CompaniesRepository(connector);
        CompaniesDao comp = new CompaniesDao();
        comp.setCompanyName("HighRes");
        comp.setCity("Lviv");
        compRep.save(comp);


        //SAVE NEW PROJECT
        Repository<ProjectsDao> projRep = new ProjectsRepository(connector);
        ProjectsDao proj = new ProjectsDao();
        proj.setProjectName("VICTORY");
        proj.setStartDate(Date.valueOf("2022-04-20"));
        proj.setCost(105000d);
        projRep.save(proj);

        //SAVE NEW SKILL
        Repository<SkillsDao> skillRep = new SkillsRepository(connector);
        SkillsDao skill = new SkillsDao();
        skill.setRank("Junior");
        skill.setSyntax("JS");
        skillRep.save(skill);


        //SAVE NEW CLIENT
        Repository<ClientsDao> clientRep = new ClientsRepository(connector);
        ClientsDao client = new ClientsDao();
        client.setName("DIGITAL AUTHORITY");
        client.setCountry("ABU DHABI");
        client.setCategory("Premium");
        clientRep.save(client);
        clientRep.selectAll().forEach(System.out::println);








    }
}
