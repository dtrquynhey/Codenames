package models;

import models.enums.Role;
import models.enums.Team;

public class GamePlayer {

    private int gamePlayerId;
    private int gameId;
    private int playerId;
    private Team team;
    private Role role;


    public GamePlayer() {
    }

    public GamePlayer(int gamePlayerId, int gameId, int playerId, Team team, Role role) {
        this.gamePlayerId = gamePlayerId;
        this.gameId = gameId;
        this.playerId = playerId;
        this.team = team;
        this.role = role;
    }


    public int getGamePlayerId() {
        return gamePlayerId;
    }

    public void setGamePlayerId(int gamePlayerId) {
        this.gamePlayerId = gamePlayerId;
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

    public Team getTeamId() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
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
                "gamePlayerId=" + gamePlayerId +
                ", gameId=" + gameId +
                ", playerId=" + playerId +
                ", team=" + team +
                ", role=" + role +
                '}';
    }
}
