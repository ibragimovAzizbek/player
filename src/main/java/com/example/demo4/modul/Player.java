package com.example.demo4.modul;

public class Player {
    private Integer playerId;
    private String playerName;
    private String playerSurname;
    private Integer playerNumber;
    private Double playerSalary;

    public Player() {
    }

    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerSurname() {
        return playerSurname;
    }

    public void setPlayerSurname(String playerSurname) {
        this.playerSurname = playerSurname;
    }

    public Integer getPlayerNumber() {
        return playerNumber;
    }

    public void setPlayerNumber(Integer playerNumber) {
        this.playerNumber = playerNumber;
    }

    public Double getPlayerSalary() {
        return playerSalary;
    }

    public void setPlayerSalary(Double playerSalary) {
        this.playerSalary = playerSalary;
    }
}
