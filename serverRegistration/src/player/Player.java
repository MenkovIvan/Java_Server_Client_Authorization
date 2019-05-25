package player;

public class Player {

    private String login;
    private String password;
    private int id;

    public Player(String login, String password, int id){
        this.login=login;
        this.password=password;
        this.id=id;
    }

    public Player(String login, String password){
        this.login=login;
        this.password=password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public int getId() {
        return id;
    }
}