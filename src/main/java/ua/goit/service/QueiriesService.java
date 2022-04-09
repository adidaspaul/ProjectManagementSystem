package ua.goit.service;

import ua.goit.config.DataBaseManagerConnector;
import ua.goit.config.HikariProvider;
import ua.goit.model.converter.QueryConverter;
import ua.goit.model.dao.*;
import ua.goit.model.dto.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QueiriesService {

    private final QueryConverter sumConverter;
//    private final DataBaseManagerConnector connector;
    private final HikariProvider connector;
    private static final String PROJECT_SALARY_SUM_HIGHEST = "SELECT pr.project_name, SUM(salary) total FROM projects as pr" +
            "INNER JOIN devprojects ON devprojects.project_id = pr.id" +
            "INNER JOIN developers ON devprojects.dev_id = developers.id" +
            "GROUP BY pr.id" +
            "ORDER BY total desc" +
            "LIMIT 1";
    private static final String PROJECT_SALARY_SUM_BY_ID = "SELECT pr.project_name, SUM(salary) FROM projects as pr " +
            "INNER JOIN devprojects ON devprojects.project_id = pr.id " +
            "INNER JOIN developers ON devprojects.dev_id = developers.id " +
            "WHERE pr.id = ? GROUP BY pr.id  LIMIT 1";
    private static final String SPECIFIC_PROJECT_DEVS = "SELECT d.name, pr.project_name FROM projects as pr " +
            "INNER JOIN devprojects ON devprojects.project_id = pr.id " +
            "INNER JOIN developers d  ON devprojects.dev_id = d.id " +
            "WHERE pr.id = ? ";
    private static final String SYNTAX_DEVS = "SELECT d.name, s.syntax FROM developers d " +
            "INNER JOIN devskills ON devskills.dev_id = d.id " +
            "INNER JOIN skills s ON devskills.skill_id = s.id " +
            "WHERE s.syntax = ? " +
            "ORDER BY d.name ";
    private static final String DEVS_RANK = "SELECT d.name, s.rank FROM developers d " +
            "INNER JOIN devskills ON devskills.dev_id = d.id " +
            "INNER JOIN skills s ON devskills.skill_id = s.id " +
            "WHERE s.rank = ? " +
            "ORDER BY d.name ";

    private static final String PROJECT_DATE_DEVS = "SELECT pr.start_date, pr.project_name, COUNT (dpr.dev_id)" +
            " FROM projects pr" +
            "  INNER JOIN devprojects dpr ON pr.id = dpr.project_id" +
            "  GROUP BY pr.start_date, pr.project_name";


    public QueiriesService(QueryConverter sumConverter, HikariProvider connector) {
        this.sumConverter = sumConverter;
        this.connector = connector;
    }


    public ProjectDevsSalarySumDto getProjectSalarySumById(Integer id) {
        ProjectDevsSalarySumDao sumDao = new ProjectDevsSalarySumDao();
        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(PROJECT_SALARY_SUM_BY_ID)) {
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
        List<SpecificProjectDevDto> list = new ArrayList<>();
        SpecificProjectDevsDao dao = new SpecificProjectDevsDao();
        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(SPECIFIC_PROJECT_DEVS)) {
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
        List<SyntaxDevsListDto> list = new ArrayList<>();
        SyntaxDevsListDao dao = new SyntaxDevsListDao();
        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(SYNTAX_DEVS)) {
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

    public List<DevsRankListDto> listOfDevsRank(String rank) {
        List<DevsRankListDto> list = new ArrayList<>();
        DevsRankListDao dao = new DevsRankListDao();
        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(DEVS_RANK)) {
            statement.setString(1, rank);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                dao.setName(rs.getString("name"));
                dao.setRank(rs.getString("rank"));
                list.add(sumConverter.convert(dao));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return List.of();
    }

    public List<ProjectDateDevsDto> listProjectDateDevs() {
        List<ProjectDateDevsDto> list = new ArrayList<>();
        ProjectDateDevsDao dao = new ProjectDateDevsDao();
        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(PROJECT_DATE_DEVS)) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                dao.setStartDate(rs.getDate("start_date"));
                dao.setProjectName(rs.getString("project_name"));
                dao.setCount(rs.getInt("count"));
                list.add(sumConverter.convert(dao));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return List.of();
    }

}




