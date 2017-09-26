package com.scottlogic.leaderboardtesting;

import javax.validation.constraints.NotNull;

public class HighScore {

    @NotNull
    private String userName;
    @NotNull
    private String gameName;
    @NotNull
    private Integer value;

    public HighScore() { }

    public HighScore(String userName, String gameName, Integer value) {
        this.userName = userName;
        this.gameName = gameName;
        this.value = value;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
