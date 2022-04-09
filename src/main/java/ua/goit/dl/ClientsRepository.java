package ua.goit.dl;

import ua.goit.config.DataBaseManagerConnector;
import ua.goit.model.dao.ClientsDao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClientsRepository implements Repository<ClientsDao> {


    private final DataBaseManagerConnector connector;

    private static final String SELECT_ALL_CLIENTS = "SELECT * FROM clients";
    private static final String UPDATE_CLIENTS = "UPDATE clients SET name = ?, country = ?, category = ? WHERE id = ?";
    private static final String DELETE_CLIENTS_BY_ID = "DELETE FROM clients WHERE id = ?";
    private static final String FIND_BY_ID = "SELECT * FROM clients c WHERE c.id = ?";
    private static final String INSERT = "INSERT INTO clients (name, country, category) VALUES (?, ?, ?)";
    private static final String INSERT_WITH_ID = "INSERT INTO clients (id, name, country, category) VALUES (?, ?, ?, ?)";


    public ClientsRepository(DataBaseManagerConnector connector) {
        this.connector = connector;
    }

    @Override
    public Optional<ClientsDao> findById(Integer id) {
        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            return mapToClientsDao(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    private Optional<ClientsDao> mapToClientsDao(ResultSet resultSet) throws SQLException {
        ClientsDao clientsDao = new ClientsDao();
        while (resultSet.next()) {
            clientsDao.setId(resultSet.getInt("id"));
            clientsDao.setName(resultSet.getString("name"));
            clientsDao.setCountry(resultSet.getString("country"));
            clientsDao.setCategory(resultSet.getString("category"));

        }
        return Optional.ofNullable(clientsDao);
    }

    @Override
    public void save(ClientsDao entity) {
        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT)) {
            statement.setString(1, entity.getName());
            statement.setString(2, entity.getCountry());
            statement.setString(3, entity.getCategory());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void saveWithId(ClientsDao entity) {
        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_WITH_ID)) {
            statement.setInt(1, entity.getId());
            statement.setString(2, entity.getName());
            statement.setString(3, entity.getCountry());
            statement.setString(4, entity.getCategory());
            statement.execute();
        } catch (SQLException e) {
            System.out.println("!!!The ID already exists!!!");
        }
    }

    @Override
    public int update(ClientsDao entity) {
        int updatedColumns = 0;
        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_CLIENTS)) {
            statement.setString(1, entity.getName());
            statement.setString(2, entity.getCountry());
            statement.setString(3, entity.getCategory());
            statement.setInt(4, entity.getId());
            updatedColumns = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return updatedColumns;
    }

    @Override
    public void delete(Integer id) {
        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_CLIENTS_BY_ID)) {
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<ClientsDao> selectAll() {
        List<ClientsDao> clientsList = new ArrayList<>();
        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL_CLIENTS)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ClientsDao clientsDao = new ClientsDao();
                clientsDao.setId(resultSet.getInt("id"));
                clientsDao.setName(resultSet.getString("name"));
                clientsDao.setCountry(resultSet.getString("country"));
                clientsDao.setCategory(resultSet.getString("category"));
                clientsList.add(clientsDao);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientsList;
    }
}
