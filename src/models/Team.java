package models;
import models.enums.Color;

import java.util.List;

public class Team {
    private int teamId;
    private List<Player> listOfPlayers;
    private Color color;
    private int score;
    private int numOfGuess;

    public Team() {
    }

    public Team(List<Player> listOfPlayers, Color color, int score, int numOfGuess) {
        this.listOfPlayers = listOfPlayers;
        this.color = color;
        this.score = score;
        this.numOfGuess = numOfGuess;
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

    public int getNumOfGuess() {
        return numOfGuess;
    }

    public void setNumOfGuess(int numOfGuess) {
        this.numOfGuess = numOfGuess;
    }

    @Override
    public String toString() {
        return "Team{" +
                "teamId='" + teamId + '\'' +
                ", listOfPlayers=" + listOfPlayers +
                ", color=" + color +
                ", score=" + score +
                ", numOfGuess=" + numOfGuess +
                '}';
    }
}
