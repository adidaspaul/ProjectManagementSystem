package ua.goit.dl;

import ua.goit.config.DataBaseManagerConnector;
import ua.goit.model.dao.SkillsDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SkillsRepository implements Repository<SkillsDao> {

    private final DataBaseManagerConnector connector;
    private static final String SELECT_ALL = "SELECT * FROM skills";
    private static final String UPDATE_SKILLS = "UPDATE skills SET rank = ?, syntax = ? WHERE id = ?";
    private static final String DELETE_SKILLS_BY_ID = "DELETE FROM skills WHERE id = ?";
    private static final String FIND_BY_ID = "SELECT * FROM skills  WHERE id = ?";
    private static final String INSERT = "INSERT INTO skills (rank, syntax) VALUES (?, ?)";
    private static final String INSERT_WITH_ID = "INSERT INTO skills (id, rank, syntax) VALUES (?, ?, ?)";

    public SkillsRepository(DataBaseManagerConnector connector) {
        this.connector = connector;
    }


    @Override
    public SkillsDao findById(Integer id) {
        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_BY_ID)) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            return mapToSkillsDao(rs).orElseThrow(() -> new IllegalArgumentException(String.format("No skills with id %d", id)));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }


    @Override
    public void save(SkillsDao entity) {
        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT)) {
            statement.setString(1, entity.getRank());
            statement.setString(2, entity.getSyntax());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void saveWithId(SkillsDao entity) {
        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_WITH_ID)) {
            statement.setInt(1, entity.getId());
            statement.setString(2, entity.getRank());
            statement.setString(3, entity.getSyntax());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int update(SkillsDao entity) {
        int columnsUpdated = 0;
        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_SKILLS)) {
            statement.setString(1, entity.getRank());
            statement.setString(2, entity.getSyntax());
            statement.setInt(3, entity.getId());
            columnsUpdated = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return columnsUpdated;
    }

    @Override
    public void delete(SkillsDao entity) {
        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_SKILLS_BY_ID)) {
            statement.setInt(1, entity.getId());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<SkillsDao> selectAll() {
        List<SkillsDao> skills = new ArrayList<>();
        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL)) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                SkillsDao skillsDao = new SkillsDao();
                skillsDao.setId(rs.getInt("id"));
                skillsDao.setRank(rs.getString("rank"));
                skillsDao.setSyntax(rs.getString("syntax"));
                skills.add(skillsDao);
                //                System.out.println(rs.getInt("id") +
//                        " " + rs.getString("rank") +
//                        " " + rs.getString("syntax");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return skills;
    }


    private Optional<SkillsDao> mapToSkillsDao(ResultSet rs) throws SQLException {
        SkillsDao skills = new SkillsDao();
        while (rs.next()) {
            skills.setId(rs.getInt("id"));
            skills.setRank(rs.getString("rank"));
            skills.setSyntax(rs.getString("skills"));
        }
        return Optional.ofNullable(skills);
    }
}
