package models;

import models.enums.Role;

public class GamePlayer extends Player{
    private int playerId;
    private Role role;


    public GamePlayer() {
    }

    public GamePlayer( int playerId, Role role) {
        this.playerId = playerId;
        this.role = role;
    }



    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }


    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }


    @Override
    public String toString() {
        return "GamePlayer{" +
                ", playerId=" + playerId +
                ", role=" + role +
                '}';
    }
    public void giveClue(String word, int num) {
        // clue giving logic
    }

    public boolean guess(Card card) {
        // guessing logic
        return false;
    }
}
