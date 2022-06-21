package application.repository.sqlite;

import domain.entities.team.Team;
import domain.usecases.team.TeamDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SqliteTeamDAO implements TeamDAO {

    @Override
    public Integer create(Team team) {
        String sql = "INSERT INTO Team(name) VALUES (?)";
        try(PreparedStatement stmt = ConnectionFactory.createPreparedStatement(sql)){
            stmt.setString(1, team.getName());
            stmt.execute();
            ResultSet resultSet = stmt.getGeneratedKeys();
            return resultSet.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Optional<Team> findOne(Integer key) {
        String sql = "SELECT * FROM Team WHERE id = ?";
        Team team = null;

        try(PreparedStatement stmt = ConnectionFactory.createPreparedStatement(sql)){
            stmt.setInt(1, key);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                team = resultSetToEntity(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(team);
    }

    private Team resultSetToEntity(ResultSet rs) throws SQLException {
        return new Team(
                rs.getInt("id"),
                rs.getString("name")
        );
    }

    @Override
    public List<Team> findAll() {
        String sql = "SELECT * FROM Team";
        List<Team> teams = new ArrayList<>();

        try(PreparedStatement stmt = ConnectionFactory.createPreparedStatement(sql)){
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Team team = resultSetToEntity(rs);
                teams.add(team);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teams;
    }

    @Override
    public boolean update(Team team) {
        String sql = "UPDATE Team SET name = ? WHERE id = ?";

        try(PreparedStatement stmt = ConnectionFactory.createPreparedStatement(sql)){
            stmt.setString(1, team.getName());
            stmt.setInt(2, team.getId());
            stmt.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteByKey(Integer key) {
        String sql = "DELETE FROM Team WHERE id = ?";
        try(PreparedStatement stmt = ConnectionFactory.createPreparedStatement(sql)) {
            stmt.setInt(1, key);
            stmt.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Team team) {
        if (team == null || team.getId() == 0)
            throw new IllegalArgumentException("Team Id must not be null.");
        return deleteByKey(team.getId());
    }
}
