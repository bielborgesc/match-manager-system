package application.repository.sqlite;

import domain.entities.score.Score;
import domain.entities.team.Team;
import domain.usecases.score.ScoreDAO;
import domain.usecases.team.TeamDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SqliteScoreDAO implements ScoreDAO {

    @Override
    public Integer create(Score score) {
        String sql = "INSERT INTO Score(idTeam, wins, loses, even, points)" +
                " VALUES (?, ?, ?, ?, ?)";
        try(PreparedStatement stmt = ConnectionFactory.createPreparedStatement(sql)){
            stmt.setInt(1, score.getIdTeam());
            stmt.setInt(2, 0);
            stmt.setInt(3, 0);
            stmt.setInt(4, 0);
            stmt.setInt(5, 0);
            stmt.execute();
            ResultSet resultSet = stmt.getGeneratedKeys();
            return resultSet.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Optional<Score> findOne(Integer key) {
        String sql = "SELECT * FROM Score WHERE idTeam = ?";
        Score score = null;

        try(PreparedStatement stmt = ConnectionFactory.createPreparedStatement(sql)){
            stmt.setInt(1, key);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                score = resultSetToEntity(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(score);
    }

    private Score resultSetToEntity(ResultSet rs) throws SQLException {
        return new Score(
                rs.getInt("idTeam")
        );
    }

    @Override
    public List<Score> findAll() {
        String sql = "SELECT * FROM Score";
        List<Score> scores = new ArrayList<>();

        try(PreparedStatement stmt = ConnectionFactory.createPreparedStatement(sql)){
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Score score = resultSetToEntity(rs);
                scores.add(score);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return scores;
    }

    @Override
    public boolean update(Score score) {
        String sql = "UPDATE Score SET wins = ?, loses = ?, even = ?, points = ? WHERE idTeam = ?";
        try(PreparedStatement stmt = ConnectionFactory.createPreparedStatement(sql)){
            stmt.setInt(1, score.getWinds());
            stmt.setInt(2, score.getLoses());
            stmt.setInt(3, score.getEven());
            stmt.setInt(4, score.getPoints());
            stmt.setInt(5, score.getIdTeam());
            stmt.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteByKey(Integer key) {
        String sql = "DELETE FROM Score WHERE idTeam = ?";
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
    public boolean delete(Score score) {
        if (score == null || score.getIdTeam() == 0)
            throw new IllegalArgumentException("Score IdTeam must not be null.");
        return deleteByKey(score.getIdTeam());
    }
}
