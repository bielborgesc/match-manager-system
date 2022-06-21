package application.repository.sqlite;

import domain.entities.match.Match;
import domain.entities.team.Team;
import domain.usecases.match.MatchDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SqliteMatchDAO implements MatchDAO {
    @Override
    public Match findMatchByIdTeam(Integer idTeam) {
        String sql = "SELECT * FROM Match WHERE id = ?";
        Match match = null;

        try (PreparedStatement stmt = ConnectionFactory.createPreparedStatement(sql)) {
            stmt.setInt(1, idTeam);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                match = resultSetToEntity(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return match;
    }

    private Match resultSetToEntity(ResultSet rs) throws SQLException {
        return new Match(
                rs.getInt("id"),
                new Team(rs.getObject(SqliteTeamDAO.findOne("teamA"))),
                new Team(rs.getObject(SqliteTeamDAO.findOne("teamB"))),
                rs.getInt("idRound")
        );
    }

    @Override
    public Integer create(Match type) {
        return null;
    }

    @Override
    public Optional<Match> findOne(Integer id) {
        String sql = "SELECT * FROM Match WHERE id = ?";
        Match match = null;

        try (PreparedStatement stmt = ConnectionFactory.createPreparedStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                match = resultSetToEntity(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(match);
    }

    @Override
    public List<Match> findAll() {
        String sql = "SELECT * FROM Match";
        List<Match> matches = new ArrayList<>();

        try(PreparedStatement stmt = ConnectionFactory.createPreparedStatement(sql)){
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Match match = resultSetToEntity(rs);
                matches.add(match);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return matches;
    }

    @Override
    public boolean update(Match match) {
        String sql = "UPDATE Match SET teamA = ?, teamB = ?, teamPointsA = ?, teamPointsB = ?, idRound = ?, isFinished = ? WHERE id = ?";

        try(PreparedStatement stmt = ConnectionFactory.createPreparedStatement(sql)){
            stmt.setObject(1, match.getTeamA());
            stmt.setObject(2, match.getTeamB());
            stmt.setInt(3, match.getTeamPointsA());
            stmt.setInt(4, match.getTeamPointsB());
            stmt.setInt(5, match.getIdRound());
            stmt.setBoolean(6, match.getStatus());
            stmt.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteByKey(Integer idMatch) {
        String sql = "DELETE FROM Match WHERE id = ?";
        try(PreparedStatement stmt = ConnectionFactory.createPreparedStatement(sql)) {
            stmt.setInt(1, idMatch);
            stmt.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Match match) {
        if (match == null || match.getId() == 0)
            throw new IllegalArgumentException("Match Id must not be null.");
        return deleteByKey(match.getId());
    }
}
