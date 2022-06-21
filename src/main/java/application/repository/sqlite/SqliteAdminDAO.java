package application.repository.sqlite;

import domain.entities.admin.Admin;
import domain.usecases.admin.AdminDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
    public Optional<Admin> findOne(String key) {
        String sql = "SELECT * FROM Admin WHERE login = ?";
        Admin admin = null;

        try(PreparedStatement stmt = ConnectionFactory.createPreparedStatement(sql)){
            stmt.setString(1, key);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                admin = resultSetToEntity(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(admin);
    }

    private Admin resultSetToEntity(ResultSet rs) throws SQLException {
        return new Admin(
                rs.getString("login"),
                rs.getString("name"),
                rs.getString("password")
        );
    }

    @Override
    public List<Admin> findAll() {
        String sql = "SELECT * FROM Admin";
        List<Admin> admins = new ArrayList<>();

        try(PreparedStatement stmt = ConnectionFactory.createPreparedStatement(sql)){
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Admin admin = resultSetToEntity(rs);
                admins.add(admin);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return admins;
    }

    @Override
    public boolean update(Admin admin) {
        String sql = "UPDATE Admin SET name = ?, password = ? WHERE login = ?";

        try(PreparedStatement stmt = ConnectionFactory.createPreparedStatement(sql)){
            stmt.setString(1, admin.getName());
            stmt.setString(2, admin.getPassword());
            stmt.setString(3, admin.getLogin());
            stmt.execute();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteByKey(String key) {
        String sql = "DELETE FROM Admin WHERE login = ?";
        try(PreparedStatement stmt = ConnectionFactory.createPreparedStatement(sql)) {
            stmt.setString(1, key);
            stmt.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Admin admin) {
        if (admin == null || admin.getLogin() == null)
            throw new IllegalArgumentException("Admin Login must not be null.");
        return deleteByKey(admin.getLogin());
    }
}
