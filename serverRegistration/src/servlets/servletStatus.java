package servlets;

import database.CheckInformation;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class servletStatus extends HttpServlet {
    public void init(ServletConfig servletConfig) {
        try {
            super.init(servletConfig);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletOutputStream os = resp.getOutputStream();
        String login = req.getParameter("login");
        System.out.println("login: "+login);


        int id =0;
        try {
            id = CheckInformation.checkLogin(login);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (id>0){
            System.out.println("Not found player.Player. Try again");
            os.print(0);
        }
        else{
            System.out.println("player id: "+id);
            try {
                if (CheckInformation.checkOnline(login)) {
                    os.print(1);
                    System.out.println("Player " + login + " is online");
                }
                else  {
                    os.print(0);
                    System.out.println("Player " + login + " is not online");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}


