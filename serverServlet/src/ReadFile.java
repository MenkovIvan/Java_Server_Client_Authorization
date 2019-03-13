import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {

    public void read(ArrayList<Player> players) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Ivan\\IdeaProjects\\serverServlet\\src\\Players"));
        String line;
        while ((line=reader.readLine()) != null){
            String[] parts = line.split(" ",3);
            Player p = new Player(parts[0], parts[1], Integer.parseInt(parts[2]));
            players.add(p);
        }

    }
}