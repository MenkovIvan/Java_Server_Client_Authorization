package servlets;

import database.Base;
import filebase.PlayerSearch;
import filebase.ReadFile;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class servletRegistration extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletOutputStream os = resp.getOutputStream();
        String login = req.getParameter("login");
        System.out.println("login: "+login);
        String password = req.getParameter("password");
        System.out.println("password: "+password);
        Base base = new Base();
        int id = 0;
        try {
            id = base.checkLogin(login);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (id !=-1) {
            try {
                base.addPlayer(login, password);
                id = base.checkPlayer(login, password);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        os.print(id);

    }

}
