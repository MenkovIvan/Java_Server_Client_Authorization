package servlets;

import database.Base;
import filebase.PlayerSearch;
import filebase.ReadFile;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

public class servletEntry extends HttpServlet {
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
            String password = req.getParameter("password");
            System.out.println("password: "+password);
            //ReadFile rf = new ReadFile();
            //ArrayList players = new ArrayList();
            //try {
            //    rf.read(players);
            //} catch (IOException e1) {
            //    e1.printStackTrace();
            //}
            //PlayerSearch playerSearch = new PlayerSearch();
            Base base = new Base();
            int id = 0;
            try {
                id = base.checkPlayer(login,password);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (id<0){
                System.out.println("Not found player.Player. Try again");
            }
            else{
                System.out.println("player id: "+id);
            }
            //resp.setContentType(String.valueOf(id));
            os.print(id);
        }


}
