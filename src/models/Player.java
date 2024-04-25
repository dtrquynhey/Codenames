package models;

public class Player {

    private String nickname;
    private Account account;

    public Player(String nickname) {
        this.nickname = nickname;
        this.account = null;
    }

    public String getNickname() {
        return nickname;
    }
    @Override
    public String toString() {
        return nickname;
    }
}
