import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

public class servletEntry extends HttpServlet {
        public void init(ServletConfig servletConfig) {
            try {
                super.init(servletConfig);
            } catch (ServletException e) {
                e.printStackTrace();
            }
        }

        /*@Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
             Получаем логин
             Получаем пароль
             Создаем лист пользователей
             Из фаила получаем всех пользователей в лист
             Ведем поиск логина
               Не нашли: возвращаем клиенту ноль
               Нашли: проверяем пароль
                 Не подходит: возвращаем клиенту ноль
                 Подходит: возвращаем клиенту айди игрока


            String login = req.getParameter("login");
            String password = req.getParameter("password");
            ReadFile rf = new ReadFile();
            ArrayList players = new ArrayList();
            try {
                rf.read(players);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            PlayerSearch playerSearch = new PlayerSearch();
            int id = playerSearch.checkPlayer(players,login,password);
            resp.setContentType(String.valueOf(id));

        }*/

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            ServletOutputStream os = resp.getOutputStream();
            String login = req.getParameter("login");
            System.out.println("login: "+login);
            String password = req.getParameter("password");
            System.out.println("password: "+password);
            ReadFile rf = new ReadFile();
            ArrayList players = new ArrayList();
            try {
                rf.read(players);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            PlayerSearch playerSearch = new PlayerSearch();
            int id = playerSearch.checkPlayer(players,login,password);
            if (id<0){
                System.out.println("Not found Player. Try again");
            }
            else{
                System.out.println("player id: "+id);
            }
            //resp.setContentType(String.valueOf(id));
            os.print(id);
        }

            /*

    @Override
    protected void	doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        User user = service.findUser(id);
        user.setName(req.getParameter("name"));
        user.setAge(Integer.parseInt(req.getParameter("age")));
        service.updateUser(user);
        resp.sendRedirect("/users");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        service.deleteUser(service.findUser(id));
        resp.sendRedirect("/users");
    }*/
}
