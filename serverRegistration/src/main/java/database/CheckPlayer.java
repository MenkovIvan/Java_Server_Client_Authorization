package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CheckPlayer {
    public static int main(String searchLogin, String searchPassword) throws SQLException, ClassNotFoundException {

        Connection connection = ConnectionMySQL.getMySQLConnection();

        Statement statement = connection.createStatement();

        String sql = "SELECT id FROM player WHERE login =  '"+ searchLogin + "' AND password = '" + searchPassword + "'";

        ResultSet rs = statement.executeQuery(sql);

        if (rs.next()) {

            System.out.println("Result set = " + rs.getInt("id"));

            return rs.getInt("id");

        } else return -1;

    }
}
