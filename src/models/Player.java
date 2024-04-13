package models;

public class Player {

    private String nickname;
    private Account account;

    public Player(String nickname) {
        this.nickname = nickname;
    }

    public Player(String nickname, Account account) {
        this.nickname = nickname;
        this.account = account;
    }

    public Player(Account account) {
        this.nickname = account.getUsername();
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
