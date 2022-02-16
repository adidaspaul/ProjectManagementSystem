package ua.goit.dl;

import ua.goit.model.dao.DevelopersDao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DevelopersRepository implements Repository<DevelopersDao> {

    private final Connection connection;
    private static final String FIND_BY_ID = "SELECT * FROM developers d WHERE d.id = ?";

    public DevelopersRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public DevelopersDao findById(Integer id) {
        try(PreparedStatement statement = connection.prepareStatement(FIND_BY_ID)){
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            return mapToDevelopersDao(resultSet);
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;

    }


    @Override
    public void save(DevelopersDao entity) {

    }

    @Override
    public void update(DevelopersDao entity) {

    }

    @Override
    public void delete(DevelopersDao entity) {

    }
    private DevelopersDao mapToDevelopersDao(ResultSet resultSet) throws SQLException {
        DevelopersDao developersDao = new DevelopersDao();
        while(resultSet.next()) {
            developersDao.setId(resultSet.getInt("id"));
            developersDao.setName(resultSet.getString("name"));
            developersDao.setSex(resultSet.getString("sex"));
            developersDao.setSalary(resultSet.getDouble("salary"));
        }
        return developersDao;
    }
}
