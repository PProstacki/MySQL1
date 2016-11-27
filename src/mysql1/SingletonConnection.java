package mysql1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class SingletonConnection {

    private static SingletonConnection instance = null;
    String ConnectionURL = "jdbc:mysql://127.0.0.1/filmy?user=root&password=haslo";
    Connection connection;
    Statement statement;

    private SingletonConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(ConnectionURL);
            statement = connection.createStatement();
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        } catch (SQLException e2) {
            e2.printStackTrace();
        }
    }

    public static SingletonConnection getInstance() {
        if (instance == null) {
            instance = new SingletonConnection();
        }
        return instance;
    }

    ResultSet executeQuery(String commandSQL) {
        try {
            return statement.executeQuery(commandSQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    int executeUpdate(String commandSQL) {
        try {
            return statement.executeUpdate(commandSQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

}
