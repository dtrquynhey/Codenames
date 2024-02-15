package models;

public class Player {

    private int playerId;
    private String username;
    private String password;


    public Player() {
    }

    public Player(int playerId, String username, String password) {
        this.playerId = playerId;
        this.username = username;
        this.password = password;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
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
                "playerId=" + playerId +
                ", username='" + username + '\'' +
                '}';
    }
}
