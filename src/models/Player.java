package models;

public class Player {

    private String nickname;
    private Account account;

    public Player(String nickname) {
        this.nickname = nickname;
    }

    public Player(Account account) {
        this.account = account;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return nickname;
    }
}
