package models;

public class Player extends User {

    private String nickname;

    public Player(String nickname) {
        this.nickname = nickname;
    }

    public Player(String username, String password, String nickname) {
        super(username, password);
        this.nickname = nickname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

}
