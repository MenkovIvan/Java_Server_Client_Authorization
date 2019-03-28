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
    public int checkLogin(ArrayList <Player> players, String searchLogin, String searchPassword){
        for (Player item : players) {
            if (item.getLogin().equals(searchLogin)){
                return -1;
            }
        }
        return players.size();
    }
}
