package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CheckInformation {

    public static String idToName(int id) throws SQLException, ClassNotFoundException {

        Connection connection = ConnectionMySQL.getMySQLConnection();

        Statement statement = connection.createStatement();

        String sql = "SELECT login FROM player WHERE id=" +id;

        ResultSet rs = statement.executeQuery(sql);

        if (rs.next()) {
            return rs.getString("login");
        } else return "0";
    }

    public static int nameToId(String login) throws SQLException, ClassNotFoundException {

        Connection connection = ConnectionMySQL.getMySQLConnection();

        Statement statement = connection.createStatement();

        String sql = "SELECT id FROM player WHERE login='" + login + "'";

        ResultSet rs = statement.executeQuery(sql);

        if (rs.next()) {
            return rs.getInt("id");
        } else return 0;
    }


    public static int checkLogin(String searchLogin) throws SQLException, ClassNotFoundException {

        Connection connection = ConnectionMySQL.getMySQLConnection();

        Statement statement = connection.createStatement();

        String sql = "SELECT id FROM player WHERE login = '" + searchLogin + "'";

        ResultSet rs = statement.executeQuery(sql);

        if (rs.next()) {
            return -1;
        } else return 1;

    }

    public static boolean checkOnline(String searchLogin) throws SQLException, ClassNotFoundException {

        Connection connection = ConnectionMySQL.getMySQLConnection();

        Statement statement = connection.createStatement();

        String sql = "SELECT id FROM player WHERE login = '" + searchLogin + "' AND online=1";

        ResultSet rs = statement.executeQuery(sql);

        if (rs.next()) {

            System.out.println("Result set = " + rs.getInt("id"));

            return true;

        } else return false;

    }

    public static int checkPlayer(String searchLogin, String searchPassword) throws SQLException, ClassNotFoundException {

        Connection connection = ConnectionMySQL.getMySQLConnection();

        Statement statement = connection.createStatement();

        String sql = "SELECT id FROM player WHERE login =  '" + searchLogin + "' AND password = '" + searchPassword + "'";

        ResultSet rs = statement.executeQuery(sql);

        if (rs.next()) {

            System.out.println("Result set = " + rs.getInt("id"));

            return rs.getInt("id");

        } else return -1;

    }

    public static int checkMeInvite(String searchLogin) throws SQLException, ClassNotFoundException {
//проверка чтобы я до этого никого не приглашал и меня до этого никто не приглашал
//проверка чтобы этого пользователя до этого никто не приглашал и он никого не приглашал
        Connection connection = ConnectionMySQL.getMySQLConnection();

        Statement statement = connection.createStatement();

        String sql = "SELECT id FROM player WHERE login= '" + searchLogin + "' AND me_invite<0 AND i_invite<0";

        ResultSet rs = statement.executeQuery(sql);

        if (rs.next()) {

            System.out.println("Result set = " + rs.getInt("id"));

            return 1;

        } else return 0;
    }


    public static int checkWhoInvite(String searchLogin) throws SQLException, ClassNotFoundException {
//проверка пригласил ли кто уже этого пользователя
        Connection connection = ConnectionMySQL.getMySQLConnection();

        Statement statement = connection.createStatement();

        String sql = "SELECT me_invite FROM player WHERE login='" + searchLogin + "'";

        ResultSet rs = statement.executeQuery(sql);

        if (rs.next()) {

            System.out.println("Result set = " + rs.getInt("me_invite"));

            return rs.getInt("me_invite");

        } else return 0;
    }

    public static int searchWhoInvite(int id) throws SQLException, ClassNotFoundException {
//проверка пригласил ли кто уже этого пользователя
        Connection connection = ConnectionMySQL.getMySQLConnection();

        Statement statement = connection.createStatement();

        String sql = "SELECT id FROM player WHERE i_invite=" + id;

        ResultSet rs = statement.executeQuery(sql);

        if (rs.next()) {

            System.out.println("Result set = " + rs.getInt("id"));

            return rs.getInt("id");

        } else return 0;
    }

    public static int getMeInvite(int id) throws SQLException, ClassNotFoundException {
//возвращаем что у этого пользователя в ми_инвайт
        Connection connection = ConnectionMySQL.getMySQLConnection();

        Statement statement = connection.createStatement();

        String sql = "SELECT me_invite FROM player WHERE id=" + id;

        ResultSet rs = statement.executeQuery(sql);

        if (rs.next()) {

            System.out.println("Result set = " + rs.getInt("me_invite"));

            return rs.getInt("me_invite");

        } else return -2;
    }

    public static int getIInvite(int id) throws SQLException, ClassNotFoundException {
//возвращаем что у этого пользователя в ай_инвайт
        Connection connection = ConnectionMySQL.getMySQLConnection();

        Statement statement = connection.createStatement();

        String sql = "SELECT i_invite FROM player WHERE id=" + id;

        ResultSet rs = statement.executeQuery(sql);

        if (rs.next()) {

            System.out.println("Result set = " + rs.getInt("i_invite"));

            return rs.getInt("i_invite");

        } else return -2;
    }

}


