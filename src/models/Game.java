package models;

import java.util.List;

import models.enums.Result;


public class Game {
    private String gameId;
    private List<Card> listOfCards;
    private List<Team> listOfTeams;
    private Result result;

    public Game() {
    }

    public Game(String gameId, List<Card> listOfCards, List<Team> listOfTeams, Result result) {
        this.gameId = gameId;
        this.listOfCards = listOfCards;
        this.listOfTeams = listOfTeams;
        this.result = result;
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

    public Result getStatus() {
        return result;
    }

    public void setStatus(Result result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Game{" +
                "gameId='" + gameId + '\'' +
                ", listOfCards=" + listOfCards +
                ", listOfTeams=" + listOfTeams +
                ", status=" + result +
                '}';
    }
}
