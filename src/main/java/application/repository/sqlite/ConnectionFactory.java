package application.repository.sqlite;
import java.sql.*;

public class ConnectionFactory {
    private static Connection connection;

    public static synchronized Connection createConnection() throws SQLException{
        if(connection == null){
            connection = DriverManager.getConnection("jdbc:sqlite:match-manager.db");
        }
        return connection;
    }

    public static PreparedStatement createPreparedStatement(String sql) throws SQLException {
        return createConnection().prepareStatement(sql);
    }

    public static Statement createStatement() throws SQLException {
        return createConnection().createStatement();
    }

}

