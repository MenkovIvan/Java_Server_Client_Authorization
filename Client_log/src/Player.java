public class Player {

    private String login;
    private String password;
    private int rang=1;

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

}
