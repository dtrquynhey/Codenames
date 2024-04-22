package models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import models.enums.GameResult;


public class Game {
    private String gameId;
    private List<Card> cards;
    private List<Player> players;
    private List<Team> teams;
    private Team redTeam;
    private Team blueTeam;
    private GameResult gameResult;

    public LocalDate getDate() {
        return date;
    }

    private LocalDate date;

    public Game() {
        this.date = LocalDate.now();
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
        this.redTeam = teams.getFirst();
        this.blueTeam = teams.get(1);
    }

    public GameResult getGameResult() {
        return gameResult;
    }

    public void setGameResult(GameResult gameResult) {
        this.gameResult = gameResult;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(String[] players) {
        this.players = new ArrayList<>();
        for (String p : players) {
            this.players.add(new Player(p));
        }
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

    public Team getRedTeam() {
        return redTeam;
    }


    public Team getBlueTeam() {
        return blueTeam;
    }

}
