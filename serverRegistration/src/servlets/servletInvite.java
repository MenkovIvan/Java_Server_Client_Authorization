package servlets;

import database.CheckInformation;
import database.UpdateInformation;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class servletInvite extends HttpServlet {
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
        String whoInvite = req.getParameter("whoinvite");
        System.out.println("who invite: " + whoInvite);
        try {
            System.out.println(CheckInformation.checkMeInvite(whoInvite));
            System.out.println(CheckInformation.checkMeInvite(CheckInformation.idToName(id)));
            if (CheckInformation.checkMeInvite(whoInvite) == 1 && CheckInformation.checkMeInvite(CheckInformation.idToName(id)) == 1) {

                UpdateInformation.updateMe_Invite(id, whoInvite);
                UpdateInformation.updateI_Invite(CheckInformation.idToName(id), CheckInformation.nameToId(whoInvite));

                os.print(1);

            }else {
                os.print(0);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

