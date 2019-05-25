package database;

import java.sql.*;

public class AddPlayer {
    public static void main(String loginPlayer, String passwordPlayer) throws SQLException, ClassNotFoundException {

        Connection connection = ConnectionMySQL.getMySQLConnection();

        Statement statement = connection.createStatement();

        String sql = "INSERT INTO player (login, password) VALUES('" + loginPlayer + "', '" + passwordPlayer + "')";

        int rowCount = statement.executeUpdate(sql);

        System.out.println("Row Count affected = " + rowCount);

    }
}
