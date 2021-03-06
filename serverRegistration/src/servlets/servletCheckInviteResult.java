package servlets;

import database.CheckInformation;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class servletCheckInviteResult extends HttpServlet {
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
        int id = Integer.parseInt(req.getParameter("id"));
        System.out.println("id: " + id);

        try {
            if (CheckInformation.getMeInvite(id) == 0){
                os.print(CheckInformation.idToName(CheckInformation.getIInvite(id)));
            }
            else os.print("0");
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
}

