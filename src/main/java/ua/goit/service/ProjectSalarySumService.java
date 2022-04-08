package ua.goit.service;

import ua.goit.config.DataBaseManagerConnector;
import ua.goit.model.converter.SumConverter;
import ua.goit.model.dao.ProjectDevsSalarySumDao;
import ua.goit.model.dto.ProjectDevsSalarySumDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProjectSalarySumService {

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


    public ProjectSalarySumService(SumConverter sumConverter, DataBaseManagerConnector connector) {
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
}


