package application.repository.sqlite;

import domain.entities.admin.Admin;
import domain.entities.round.Round;
import domain.usecases.round.RoundDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SqliteRoundDAO implements RoundDAO {
    @Override
    public Integer create(Round round) {
        String sql = "INSERT INTO Round(id) VALUES (?)";
        try(PreparedStatement stmt = ConnectionFactory.createPreparedStatement(sql)){
            stmt.setInt(1, round.getId());
            stmt.execute();
            ResultSet resultSet = stmt.getGeneratedKeys();
            return resultSet.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Optional<Round> findOne(Integer id) {
        String sql = "SELECT * FROM Round WHERE id = ?";
        Round round = null;

        try(PreparedStatement stmt = ConnectionFactory.createPreparedStatement(sql)){
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                round = resultSetToEntity(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(round);
    }

    private Round resultSetToEntity(ResultSet rs) throws SQLException {
        return new Round(
                rs.getInt("id")
        );
    }

    @Override
    public List<Round> findAll() {
        String sql = "SELECT * FROM Round";
        List<Round> rounds = new ArrayList<>();

        try(PreparedStatement stmt = ConnectionFactory.createPreparedStatement(sql)){
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Round round = resultSetToEntity(rs);
                rounds.add(round);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rounds;
    }

    @Override
    public boolean update(Round round) {
        String sql = "UPDATE Round SET id = ? WHERE id = ?";

        try(PreparedStatement stmt = ConnectionFactory.createPreparedStatement(sql)){
            stmt.setInt(1, round.getId());
            stmt.execute();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteByKey(Integer id) {
        String sql = "DELETE FROM Round WHERE id = ?";
        try(PreparedStatement stmt = ConnectionFactory.createPreparedStatement(sql)) {
            stmt.setInt(1, id);
            stmt.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Round round) {
        if (round == null)
            throw new IllegalArgumentException("Round Login must not be null.");
        return deleteByKey(round.getId());
    }
}
