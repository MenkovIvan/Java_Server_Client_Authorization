import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadFile {

    public void read(ArrayList a) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Ivan\\IdeaProjects\\Server_log\\src\\Players"));
        String line;
        while ((line=reader.readLine()) != null){
            String[] parts = line.split(" ",2);
            Player p = new Player(parts[0], parts[1]);
            a.add(p);
        }
    }
}