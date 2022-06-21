package application.repository.sqlite;

import domain.entities.admin.Admin;

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

    }

    private static void build() {
        try (Statement statement = ConnectionFactory.createStatement()) {
            statement.addBatch(createAdmin());
            statement.addBatch(createTeam());
            statement.addBatch(createScore());
            statement.addBatch(createMatch());
            statement.addBatch(createRound());
            statement.addBatch(createChampionship());
            statement.addBatch(createMatchInRound());
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

    private static String createScore() {
        StringBuilder builder = new StringBuilder();

        builder.append("CREATE TABLE Score (\n");
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

    private static String createMatch() {
        StringBuilder builder = new StringBuilder();

        builder.append("CREATE TABLE Match (\n");
        builder.append("id INTEGER PRIMARY KEY, \n");
        builder.append("idTeam INTEGER NOT NULL, \n");
        builder.append("wins INTEGER NOT NULL, \n");
        builder.append("loses INTEGER NOT NULL, \n");
        builder.append("even INTEGER NOT NULL, \n");
        builder.append("points INTEGER NOT NULL, \n");
        builder.append("FOREIGN KEY(idTeam) REFERENCES Team(id)\n");
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

    private static String createMatchInRound() {
        StringBuilder builder = new StringBuilder();
        builder.append("CREATE TABLE MatchInRound (\n");
        builder.append("idRound INTEGER NOT NULL, \n");
        builder.append("idMatch INTEGER NOT NULL, \n");
        builder.append("FOREIGN KEY(idRound) REFERENCES Round(id),\n");
        builder.append("FOREIGN KEY(idMatch) REFERENCES Match(id)\n");
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
