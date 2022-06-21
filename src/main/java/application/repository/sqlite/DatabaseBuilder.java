package application.repository.sqlite;

import domain.entities.admin.Admin;
import domain.entities.score.Score;
import domain.entities.team.Team;
import domain.usecases.admin.AdminDAO;
import domain.usecases.score.ScoreDAO;
import domain.usecases.team.TeamDAO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseBuilder {
    public static void main(String[] args) {
        clear();
        build();
        insert();
    }

    private static void clear() {
        System.out.println("Cleaning up...");
        try {
            Files.deleteIfExists(Paths.get("match-manager.db"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void insert(){
        Admin admin = new Admin("jose", "jose", "123");
        AdminDAO adminDAO = new SqliteAdminDAO();
        adminDAO.create(admin);

        Team team1 = new Team(1, "Corinthians");
        Team team2 = new Team(2,"São Paulo");
        Team team3 = new Team(3, "Bahia");
        Team team4 = new Team(4, "Santos");
        Team team5 = new Team(5, "Sporte");
        Team team6 = new Team(6, "Juninho");
        Team team7 = new Team(7, "Palmeiras");
        Team team8 = new Team(8, "Renato");

        TeamDAO teamDAO = new SqliteTeamDAO();
        teamDAO.create(team1);
        teamDAO.create(team2);
        teamDAO.create(team3);
        teamDAO.create(team4);
        teamDAO.create(team5);
        teamDAO.create(team6);
        teamDAO.create(team7);
        teamDAO.create(team8);

        Score score1 = new Score(team1.getId());
        Score score2 = new Score(team2.getId());
        Score score3 = new Score(team3.getId());
        Score score4 = new Score(team4.getId());
        Score score5 = new Score(team5.getId());
        Score score6 = new Score(team6.getId());
        Score score7 = new Score(team7.getId());
        Score score8 = new Score(team8.getId());

        ScoreDAO scoreDAO = new SqliteScoreDAO();
        scoreDAO.create(score1);
        scoreDAO.create(score2);
        scoreDAO.create(score3);
        scoreDAO.create(score4);
        scoreDAO.create(score5);
        scoreDAO.create(score6);
        scoreDAO.create(score7);
        scoreDAO.create(score8);

    }

    private static void build() {
        try (Statement statement = ConnectionFactory.createStatement()) {
            statement.addBatch(createAdmin());
            statement.addBatch(createTeam());
            statement.addBatch(createScore());
            statement.addBatch(createMatch());
            statement.addBatch(createRound());
            statement.addBatch(createChampionship());
            statement.addBatch(createRoundInChampionship());
            statement.addBatch(createTeamInChampionship());
            statement.executeBatch();

            System.out.println("Database successfully created.");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    private static String createAdmin() {
        StringBuilder builder = new StringBuilder();

        builder.append("CREATE TABLE Admin (\n");
        builder.append("login VARCHAR PRIMARY KEY NOT NULL, \n");
        builder.append("name TEXT NOT NULL, \n");
        builder.append("password TEXT NOT NULL \n");
        builder.append("); \n");

        System.out.println(builder.toString());
        return builder.toString();
    }

    private static String createTeam() {
        StringBuilder builder = new StringBuilder();

        builder.append("CREATE TABLE Team (\n");
        builder.append("id INTEGER PRIMARY KEY AUTOINCREMENT, \n");
        builder.append("name VARCHAR NOT NULL \n");
        builder.append("); \n");

        System.out.println(builder.toString());
        return builder.toString();
    }

    private static String createMatch() {
        StringBuilder builder = new StringBuilder();

        builder.append("CREATE TABLE Match (\n");
        builder.append("id INTEGER PRIMARY KEY AUTOINCREMENT, \n");
        builder.append("teamA INTEGER NOT NULL, \n");
        builder.append("teamB INTEGER NOT NULL, \n");
        builder.append("teamPointsA INTEGER NOT NULL, \n");
        builder.append("teamPointsB INTEGER NOT NULL, \n");
        builder.append("idRound INTEGER NOT NULL, \n");
        builder.append("isFinished BOOLEAN NOT NULL, \n");
        builder.append("FOREIGN KEY(teamA) REFERENCES Team(id),\n");
        builder.append("FOREIGN KEY(teamB) REFERENCES Team(id),\n");
        builder.append("FOREIGN KEY(idRound) REFERENCES Round(id)\n");
        builder.append("); \n");

        System.out.println(builder.toString());
        return builder.toString();
    }

    private static String createRound() {
        StringBuilder builder = new StringBuilder();

        builder.append("CREATE TABLE Round (\n");
        builder.append("id INTEGER PRIMARY KEY AUTOINCREMENT \n");
        builder.append("); \n");

        System.out.println(builder.toString());
        return builder.toString();
    }

    private static String createScore() {
        StringBuilder builder = new StringBuilder();

        builder.append("CREATE TABLE Score (\n");
        builder.append("idTeam INTEGER PRIMARY KEY NOT NULL, \n");
        builder.append("wins INTEGER NOT NULL, \n");
        builder.append("loses INTEGER NOT NULL, \n");
        builder.append("even INTEGER NOT NULL, \n");
        builder.append("points INTEGER NOT NULL \n");
        builder.append("); \n");

        System.out.println(builder.toString());
        return builder.toString();
    }

    private static String createChampionship() {
        StringBuilder builder = new StringBuilder();

        builder.append("CREATE TABLE Championship (\n");
        builder.append("id INTEGER PRIMARY KEY AUTOINCREMENT, \n");
        builder.append("name VARCHAR NOT NULL, \n");
        builder.append("date DATE NOT NULL, \n");
        builder.append("typeEnum VARCHAR NOT NULL, \n");
        builder.append("categoryEnum VARCHAR NOT NULL\n");
        builder.append("); \n");

        System.out.println(builder.toString());
        return builder.toString();
    }

    private static String createTeamInChampionship() {
        StringBuilder builder = new StringBuilder();
        builder.append("CREATE TABLE TeamInChampionship (\n");
        builder.append("idTeam INTEGER NOT NULL, \n");
        builder.append("idChampionship INTEGER NOT NULL, \n");
        builder.append("FOREIGN KEY(idTeam) REFERENCES Team(id),\n");
        builder.append("FOREIGN KEY(idChampionship) REFERENCES Championship(id)\n");
        builder.append("); \n");

        System.out.println(builder.toString());
        return builder.toString();
    }

    private static String createRoundInChampionship() {
        StringBuilder builder = new StringBuilder();
        builder.append("CREATE TABLE RoundInChampionship (\n");
        builder.append("idRound INTEGER NOT NULL, \n");
        builder.append("idChampionship INTEGER NOT NULL, \n");
        builder.append("FOREIGN KEY(idRound) REFERENCES Round(id),\n");
        builder.append("FOREIGN KEY(idChampionship) REFERENCES Championship(id)\n");
        builder.append("); \n");

        System.out.println(builder.toString());
        return builder.toString();
    }

}
