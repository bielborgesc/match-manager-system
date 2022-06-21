package application.repository.sqlite;

import domain.entities.championship.CategoryEnum;
import domain.entities.championship.Championship;
import domain.entities.championship.TypeEnum;
import domain.entities.round.Round;
import domain.entities.team.Team;
import domain.usecases.championship.ChampionshipDAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SqliteChampionshipDAO implements ChampionshipDAO {

    @Override
    public Integer create(Championship championship) {
        String sql = "INSERT INTO Championship(name, date, typeEnum, categoryEnum) VALUES (?, ?, ?, ?)";
        try(PreparedStatement stmt = ConnectionFactory.createPreparedStatement(sql)){
            stmt.setString(1, championship.getName());
            stmt.setDate(2, (Date) championship.getDate());
            stmt.setString(3, championship.getTypeEnum().toString());
            stmt.setString(3, championship.getCategoryEnum().toString());
            stmt.execute();
            ResultSet resultSet = stmt.getGeneratedKeys();
            return resultSet.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Optional<Championship> findOne(Integer key) {
        String sql = "SELECT * FROM Championship WHERE id = ?";
        Championship championship = null;

        try(PreparedStatement stmt = ConnectionFactory.createPreparedStatement(sql)){
            stmt.setInt(1, key);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                championship = resultSetToEntity(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(championship);
    }

    private Championship resultSetToEntity(ResultSet rs) throws SQLException {
        return new Championship(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getDate("date"),
                TypeEnum.toEnum(rs.getString( "typeEnum")),
                CategoryEnum.toEnum(rs.getString("categoryEnum"))
        );
    }

    private Round resultSetToEntityRound(ResultSet rs) throws SQLException {
        return new Round(
                rs.getInt("id")
        );
    }

    private Team resultSetToEntityTeam(ResultSet rs) throws SQLException {
        return new Team(
                rs.getInt("id"),
                rs.getString("name")
        );
    }

    @Override
    public List<Championship> findAll() {
        String sql = "SELECT * FROM Championship";
        List<Championship> championships = new ArrayList<>();

        try(PreparedStatement stmt = ConnectionFactory.createPreparedStatement(sql)){
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Championship championship = resultSetToEntity(rs);
                championships.add(championship);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return championships;
    }

    @Override
    public boolean update(Championship championship) {
        String sql = "UPDATE Championship SET name = ?, date = ?, typeEnum = ?, categoryEnum = ?  WHERE id = ?";

        try(PreparedStatement stmt = ConnectionFactory.createPreparedStatement(sql)){
            stmt.setString(1, championship.getName());
            stmt.setDate(2, (Date) championship.getDate());
            stmt.setString(3, championship.getTypeEnum().toString());
            stmt.setString(4, championship.getCategoryEnum().toString());
            stmt.setInt(5, championship.getId());
            stmt.execute();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteByKey(Integer key) {
        String sql = "DELETE FROM Championship WHERE id = ?";
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
    public boolean delete(Championship championship) {
        if (championship == null || championship.getId() == 0)
            throw new IllegalArgumentException("Admin Login must not be null.");
        return deleteByKey(championship.getId());
    }

    @Override
    public void addRoundInChampionship(Round round, Integer idChampionship) {
        String sql = "INSERT INTO RoundInChampionship(idRound, idChampionship) VALUES (?, ?)";
        try(PreparedStatement stmt = ConnectionFactory.createPreparedStatement(sql)){
            stmt.setInt(1, round.getId());
            stmt.setInt(2, idChampionship);
            stmt.execute();
            ResultSet resultSet = stmt.getGeneratedKeys();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addTeamInChampionship(Team team, Integer idChampionship) {
        String sql = "INSERT INTO TeamInChampionship(idTeam, idChampionship) VALUES (?, ?)";
        try(PreparedStatement stmt = ConnectionFactory.createPreparedStatement(sql)){
            stmt.setInt(1, team.getId());
            stmt.setInt(2, idChampionship);
            stmt.execute();
            ResultSet resultSet = stmt.getGeneratedKeys();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Round> getRoundsInChampionship(Integer idChampionship) {
        String sql = "SELECT * FROM Round r JOIN RoundInChampionship rc on r.id = rc.idRound " +
                " JOIN Championship c on rc.idChampionship = c.id";
        List<Round> rounds = new ArrayList<>();

        try(PreparedStatement stmt = ConnectionFactory.createPreparedStatement(sql)){
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Round round = resultSetToEntityRound(rs);
                rounds.add(round);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rounds;
    }

    @Override
    public List<Team> getTeamsInChampionship(Integer idChampionship) {
        String sql = "SELECT * FROM Team t JOIN TeamInChampionship tc on t.id = rc.idTeam " +
                " JOIN Championship c on tc.idChampionship = c.id";
        List<Team> teams = new ArrayList<>();

        try(PreparedStatement stmt = ConnectionFactory.createPreparedStatement(sql)){
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Team team = resultSetToEntityTeam(rs);
                teams.add(team);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teams;
    }
}
