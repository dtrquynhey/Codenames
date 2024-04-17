package models;
import models.enums.Color;

import java.util.List;

public class Team {
    private int teamId;
    private List<Player> listOfPlayers;
    private Player spymaster;
    private Player operative;
    private Color color;
    private int score;
    private boolean isWinner;

    public Team() {
    }


    public Team(Player spymaster, Player operative, Color color, boolean isWinner) {
        this.spymaster = spymaster;
        this.operative = operative;
        this.color = color;
        this.isWinner = isWinner;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public List<Player> getListOfPlayers() {
        return listOfPlayers;
    }

    public void setListOfPlayers(List<Player> listOfPlayers) {
        this.listOfPlayers = listOfPlayers;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Team{" +
                "teamId='" + teamId + '\'' +
                ", Spymaster=" + spymaster.getNickname() +
                ", Operative=" + operative.getNickname() +
                ", color=" + color +
                ", score=" + score +
                '}';
    }

    public String getSpymaster() {
        return spymaster.getNickname();
    }

    public void setSpymaster(Player spymaster) {
        this.spymaster = spymaster;
    }

    public String getOperative() {
        return operative.getNickname();
    }

    public void setOperative(Player operative) {
        this.operative = operative;
    }

    public boolean isWinner() {
        return isWinner;
    }

    public void setWinner(boolean winner) {
        isWinner = winner;
    }
}
