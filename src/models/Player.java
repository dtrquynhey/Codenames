package models;

public class Player {

    private String nickname;
    private Account account;

    public Player(String nickname) {
        this.nickname = nickname;
        this.account = null;
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
    public Account getAccount() {
        return account;
    }
    public void setAccount(Account account) {
        this.account = account;
    }
    @Override
    public String toString() {
        return nickname;
    }
}
