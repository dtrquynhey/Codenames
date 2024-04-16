package models;

import java.util.Date;
import java.util.List;

import models.enums.GameResult;


public class Game {
    private String gameId;
    private List<Card> cards;


    private List<Player> players;
    private List<Team> teams;
    private GameResult gameResult;
    private Date date;

    public Game() {
        this.date = new Date();
    }

    public Game(String gameId, List<Card> cards, List<Team> teams) {
        this.gameId = gameId;
        this.cards = cards;
        this.teams = teams;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    public GameResult getStatus() {
        return gameResult;
    }

    public void setStatus(GameResult gameResult) {
        this.gameResult = gameResult;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
    @Override
    public String toString() {
        return "Game{" +
                "gameId='" + gameId + '\'' +
                ", listOfCards=" + cards +
                ", listOfTeams=" + teams +
                ", status=" + gameResult +
                '}';
    }
}
