import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadFile {

    public void read(ArrayList<Player> players) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Ivan\\IdeaProjects\\serverMunchikin\\src\\Players"));
        String line;
        while ((line=reader.readLine()) != null){
            String[] parts = line.split(" ",3);
            Player p = new Player(parts[1], parts[2], Integer.parseInt(parts[0]));
            players.add(p);
        }

    }
}