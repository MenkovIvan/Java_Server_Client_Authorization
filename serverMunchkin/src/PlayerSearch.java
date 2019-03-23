import java.util.ArrayList;

public class PlayerSearch {
    public int checkPlayer(ArrayList <Player> players, String searchLogin, String searchPassword){
        for (Player item : players) {
            if (item.getLogin().equals(searchLogin) && item.getPassword().equals(searchPassword)){
                return item.getId();
            }
        }
        return -1;
    }
}
