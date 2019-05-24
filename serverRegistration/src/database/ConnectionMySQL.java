package database;

import java.sql.*;

public class ConnectionMySQL {
    public static Connection getMySQLConnection() throws SQLException, ClassNotFoundException {

        String hostName = "localhost";

        String dbName = "authorization";

        String userName = "ivan";

        String password = "1";

        return getMySQLConnection(hostName, dbName, userName, password);
    }

    public static Connection getMySQLConnection(String hostName, String dbName, String userName, String password) throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.jdbc.Driver");

        String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;

        Connection conn = DriverManager.getConnection(connectionURL, userName, password);

        return conn;
    }
}
