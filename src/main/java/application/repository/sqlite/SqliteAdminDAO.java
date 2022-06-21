package application.repository.sqlite;

import domain.entities.admin.Admin;
import domain.usecases.admin.AdminDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class SqliteAdminDAO implements AdminDAO {

    @Override
    public String create(Admin admin) {
        String sql = "INSERT INTO Admin(login, name, password) VALUES (?, ?, ?)";
        try(PreparedStatement stmt = ConnectionFactory.createPreparedStatement(sql)){
            stmt.setString(1, admin.getLogin());
            stmt.setString(2, admin.getName());
            stmt.setString(3, admin.getPassword());
            stmt.execute();

            ResultSet resultSet = stmt.getGeneratedKeys();
            return resultSet.getString(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Optional<Admin> findOne(String type) {
        return Optional.empty();
    }

    @Override
    public List<Admin> findAll() {
        return null;
    }

    @Override
    public boolean update(Admin type) {
        return false;
    }

    @Override
    public boolean deleteByKey(String key) {
        return false;
    }

    @Override
    public boolean delete(Admin type) {
        return false;
    }
}
