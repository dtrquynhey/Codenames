package models;

import models.enums.Status;

import java.util.List;


public class Game {
    private String gameId;
    private List<Card> listOfCards;
    private List<Team> listOfTeams;
    private Status status;

    public Game() {
    }

    public Game(String gameId, List<Card> listOfCards, List<Team> listOfTeams, Status status) {
        this.gameId = gameId;
        this.listOfCards = listOfCards;
        this.listOfTeams = listOfTeams;
        this.status = status;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public List<Card> getListOfCards() {
        return listOfCards;
    }

    public void setListOfCards(List<Card> listOfCards) {
        this.listOfCards = listOfCards;
    }

    public List<Team> getListOfTeams() {
        return listOfTeams;
    }

    public void setListOfTeams(List<Team> listOfTeams) {
        this.listOfTeams = listOfTeams;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Game{" +
                "gameId='" + gameId + '\'' +
                ", listOfCards=" + listOfCards +
                ", listOfTeams=" + listOfTeams +
                ", status=" + status +
                '}';
    }
    public void startGame() {
        // start game logic
    }

    public boolean checkWinCondition() {
        // win condition checking logic
        return false;
    }

    public void revealCard() {
        // reveal card logic
    }

    public void operation() {
        // additional operations
    }
}
