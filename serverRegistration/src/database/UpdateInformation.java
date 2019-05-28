package database;

import java.sql.*;

public class UpdateInformation {
    public static void updateOnline(int id, int online) throws SQLException, ClassNotFoundException {

        Connection connection = ConnectionMySQL.getMySQLConnection();

        Statement statement = connection.createStatement();

        String sql = "UPDATE player SET online=" + online + " WHERE id=" + id;

        int rowCount = statement.executeUpdate(sql);

        System.out.println("Row Count affected = " + rowCount);

    }

    public static void updateMe_Invite(int who, String invite) throws SQLException, ClassNotFoundException {

        Connection connection = ConnectionMySQL.getMySQLConnection();

        Statement statement = connection.createStatement();

        String sql = "UPDATE player SET me_invite=" + who + " WHERE login='" + invite + "'";

        int rowCount = statement.executeUpdate(sql);

        System.out.println("Row Count affected = " + rowCount);

    }

    public static void updateI_Invite(String mylogin, int who) throws SQLException, ClassNotFoundException {

        Connection connection = ConnectionMySQL.getMySQLConnection();

        Statement statement = connection.createStatement();

        String sql = "UPDATE player SET i_invite=" + who + " WHERE login='" + mylogin + "'";

        int rowCount = statement.executeUpdate(sql);

        System.out.println("Row Count affected = " + rowCount);

    }
}
