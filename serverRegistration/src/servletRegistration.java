import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class servletRegistration extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletOutputStream os = resp.getOutputStream();
        String login = req.getParameter("login");
        System.out.println("login: "+login);
        String password = req.getParameter("password");
        System.out.println("password: "+password);
        ReadFile rf = new ReadFile();
        ArrayList players = new ArrayList();
        PlayerSearch playerSearch = new PlayerSearch();
        try {
            rf.read(players);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        int id = playerSearch.checkLogin(players,login,password);
        if (id !=-1)
            rf.input(id,login,password);
        os.print(id);

    }

   /* @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }*/
}
