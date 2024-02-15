package models;

import java.sql.Timestamp;

public class Turn {

    private int turnId;
    private int gameId;
    private int playerId;
    private Timestamp startTime;
    private Timestamp endTime;


    public Turn() {
    }

    public Turn(int turnId, int gameId, int playerId, Timestamp startTime, Timestamp endTime) {
        this.turnId = turnId;
        this.gameId = gameId;
        this.playerId = playerId;
        this.startTime = startTime;
        this.endTime = endTime;
    }


    public int getTurnId() {
        return turnId;
    }

    public void setTurnId(int turnId) {
        this.turnId = turnId;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
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


    @Override
    public String toString() {
        return "Turn{" +
                "turnId=" + turnId +
                ", gameId=" + gameId +
                ", playerId=" + playerId +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
