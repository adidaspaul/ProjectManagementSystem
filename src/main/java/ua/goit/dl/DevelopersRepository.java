package ua.goit.dl;

import ua.goit.config.DataBaseManagerConnector;
import ua.goit.model.dao.DevelopersDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DevelopersRepository implements Repository<DevelopersDao> {

    private final DataBaseManagerConnector connector;
    private static final String FIND_BY_ID = "SELECT * FROM developers d WHERE d.id = ?";
    private static final String INSERT = "INSERT INTO developers (name, sex, salary) VALUES (?, ?, ?)";

    public DevelopersRepository(DataBaseManagerConnector connector) {
        this.connector = connector;
    }

    @Override
    public DevelopersDao findById(Integer id) {
        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            return mapToDevelopersDao(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }


    @Override
    public void save(DevelopersDao developers) {
        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT)) {
            statement.setString(1, developers.getName());
            statement.setString(2, developers.getSex());
            statement.setDouble(3, developers.getSalary());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(DevelopersDao entity) {

    }

    @Override
    public void remove(DevelopersDao entity) {

    }

    private DevelopersDao mapToDevelopersDao(ResultSet resultSet) throws SQLException {
        DevelopersDao developersDao = new DevelopersDao();
        while (resultSet.next()) {
            developersDao.setId(resultSet.getInt("id"));
            developersDao.setName(resultSet.getString("name"));
            developersDao.setSex(resultSet.getString("sex"));
            developersDao.setSalary(resultSet.getDouble("salary"));
        }
        return developersDao;
    }
}
