package models;

public class Player {


    private String username;
    private String password;


    public Player() {
    }

    public Player( String username, String password) {

        this.username = username;
        this.password = password;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "Player{" +
                ", username='" + username + '\'' +
                '}';
    }
    public void registerPlayer() {
        // registration logic
    }

    public void loginPlayer() {
        // login logic
    }
}
