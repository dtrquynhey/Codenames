package models;

import models.enums.GameStatus;

import java.sql.Timestamp;

public class Game {

    private int gameId;
    private Timestamp startTime;
    private Timestamp endTime;
    private GameStatus status;


    public Game() {
    }

    public Game(int gameId, Timestamp startTime, Timestamp endTime, GameStatus status) {
        this.gameId = gameId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status;
    }


    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public GameStatus getStatus() {
        return status;
    }

    public void setStatus(GameStatus status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return "Game{" +
                "gameId=" + gameId +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", status=" + status +
                '}';
    }
}
