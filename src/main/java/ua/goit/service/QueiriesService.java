package ua.goit.service;

import ua.goit.config.DataBaseManagerConnector;
import ua.goit.model.converter.SumConverter;
import ua.goit.model.dao.ProjectDevsSalarySumDao;
import ua.goit.model.dao.SpecificProjectDevsDao;
import ua.goit.model.dao.SyntaxDevsListDao;
import ua.goit.model.dto.ProjectDevsSalarySumDto;
import ua.goit.model.dto.SpecificProjectDevDto;
import ua.goit.model.dto.SyntaxDevsListDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QueiriesService {

    private final SumConverter sumConverter;
    private final DataBaseManagerConnector connector;
    private static final String PROJECTSALARYSUMHIGHEST = "SELECT pr.project_name, SUM(salary) total FROM projects as pr" +
            "INNER JOIN devprojects ON devprojects.project_id = pr.id" +
            "INNER JOIN developers ON devprojects.dev_id = developers.id" +
            "GROUP BY pr.id" +
            "ORDER BY total desc" +
            "LIMIT 1";
    private static final String PROJECTSALARYSUMBYID = "SELECT pr.project_name, SUM(salary) FROM projects as pr " +
            "INNER JOIN devprojects ON devprojects.project_id = pr.id " +
            "INNER JOIN developers ON devprojects.dev_id = developers.id " +
            "WHERE pr.id = ? GROUP BY pr.id  LIMIT 1";
    private static final String SPECIFICPROJECTDEVS = "SELECT d.name, pr.project_name FROM projects as pr " +
            "INNER JOIN devprojects ON devprojects.project_id = pr.id " +
            "INNER JOIN developers d  ON devprojects.dev_id = d.id " +
            "WHERE pr.id = ? ";
    private static final String SYNTAXDEVS = "SELECT d.name, s.syntax FROM developers d " +
            "INNER JOIN devskills ON devskills.dev_id = d.id " +
            "INNER JOIN skills s ON devskills.skill_id = s.id " +
            "WHERE s.syntax = ? " +
            "ORDER BY d.name ";


    public QueiriesService(SumConverter sumConverter, DataBaseManagerConnector connector) {
        this.sumConverter = sumConverter;
        this.connector = connector;
    }


    public ProjectDevsSalarySumDto getProjectSalarySumById(Integer id) {
        ProjectDevsSalarySumDao sumDao = new ProjectDevsSalarySumDao();
        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(PROJECTSALARYSUMBYID)) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                sumDao.setProjectName(rs.getString("project_name"));
                sumDao.setSum(rs.getInt("sum"));
            }
            return sumConverter.convert(sumDao);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<SpecificProjectDevDto> listOfSpecificProjectDev(Integer id) {
        List<SpecificProjectDevDto> list = new ArrayList();
        SpecificProjectDevsDao dao = new SpecificProjectDevsDao();
        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(SPECIFICPROJECTDEVS)) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                dao.setName(rs.getString("name"));
                dao.setProjectName(rs.getString("project_name"));
                list.add(sumConverter.convert(dao));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return List.of();
    }


    public List<SyntaxDevsListDto> listOfDevSyntax(String syntax) {
        List<SyntaxDevsListDto> list = new ArrayList();
        SyntaxDevsListDao dao = new SyntaxDevsListDao();
        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(SYNTAXDEVS)) {
            statement.setString(1, syntax.toLowerCase());
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                dao.setName(rs.getString("name"));
                dao.setSyntax(rs.getString("syntax"));
                list.add(sumConverter.convert(dao));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return List.of();
    }

}


