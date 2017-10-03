package com.scottlogic.leaderboardtesting;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class HighScore {

    @NotNull
    @Size(min = 1)
    private String userName;

    @NotNull
    @Size(min = 1)
    private String gameName;

    @NotNull
    @Max(50)
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
