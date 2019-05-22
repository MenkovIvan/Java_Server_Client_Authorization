package database;

import player.Player;

import java.sql.*;
import java.util.ArrayList;

public class Base {

    public static void addPlayer(String loginPlayer, String passwordPlayer) throws ClassNotFoundException, SQLException {
        String userName = "ivan";
        String password = "1";
        String connectionURL = "jdbc:mysql://localhost:3306/authorization?useSSL=false";
        //Class.forName("com.mysql.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection(connectionURL, userName, password); Statement statement = connection.createStatement()) {
            statement.executeUpdate("INSERT INTO player (login, password) VALUES('" + loginPlayer + "', '" + passwordPlayer + "')");
        }
    }

    public static int checkPlayer(String searchLogin, String searchPassword) throws ClassNotFoundException, SQLException {
        String userName = "ivan";
        String password = "1";
        String connectionURL = "jdbc:mysql://localhost:3306/authorization?useSSL=false";
        //Class.forName("com.mysql.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection(connectionURL, userName, password); Statement statement = connection.createStatement()) {
            ResultSet rs2 = statement.executeQuery("SELECT id FROM player WHERE login = '" + searchLogin + "' AND password = '" + searchPassword + "'");
            if (rs2.next()) {
                return rs2.getInt("id");
            } else return -1;
        }
    }


    public static int checkLogin(String searchLogin) throws ClassNotFoundException, SQLException {
        String userName = "ivan";
        String password = "1";
        String connectionURL = "jdbc:mysql://localhost:3306/authorization?useSSL=false";
        //Class.forName("com.mysql.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection(connectionURL, userName, password); Statement statement = connection.createStatement()) {
            ResultSet rs2 = statement.executeQuery("SELECT id FROM player WHERE login = '" + searchLogin + "'");
            if (rs2.next()) {
                return -1;
            } else return 1;
        }
    }
}
