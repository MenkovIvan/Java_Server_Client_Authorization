package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CheckLogin {
    public static int main(String searchLogin) throws SQLException, ClassNotFoundException {

        Connection connection = ConnectionMySQL.getMySQLConnection();

        Statement statement = connection.createStatement();

        String sql = "SELECT id FROM player WHERE login = '" + searchLogin + "'";

        ResultSet rs = statement.executeQuery(sql);

        if (rs.next()) {
            return -1;
        } else return 1;

    }
}
