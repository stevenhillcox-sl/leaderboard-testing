package com.scottlogic.leaderboardtesting;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;

public class HighScoreRepository {
    private Collection<HighScore> highScores;

    private Comparator<HighScore> sortDescending = (x, y) -> y.getValue() - x.getValue();

    public HighScoreRepository() {
        this.highScores = new ArrayList<HighScore>();
    }

    public HighScoreRepository(Collection<HighScore> highScores) {
        this.highScores = new ArrayList<>(highScores);
    }

    public Collection<HighScore> getAllHighScores() {
        return this.highScores.stream()
                          .sorted(sortDescending)
                          .collect(Collectors.toList());
    }

    public Collection<HighScore> getScoresByUserName(String userName) {
        return this.highScores.stream()
                          .filter(s -> s.getUserName().equals(userName))
                          .sorted(sortDescending)
                          .collect(Collectors.toList());
    }

    public Collection<HighScore> getScoresByGameName(String gameName) {
        return this.highScores.stream()
                .filter(s -> s.getGameName().equals(gameName))
                .sorted(sortDescending)
                .collect(Collectors.toList());
    }

    public void add(HighScore newHighScore) {
        if(newHighScore.getValue() == null) {
            throw new IllegalArgumentException("High score value can not be null");
        }

        if(newHighScore.getGameName() == null || newHighScore.getGameName().isEmpty()) {
            throw new IllegalArgumentException("High score game name can not be null or empty");
        }

        if(newHighScore.getUserName() == null || newHighScore.getUserName().isEmpty()) {
            throw new IllegalArgumentException("High score user name can not be null or empty");
        }

        if(newHighScore.getValue() > 50) {
            throw new IllegalArgumentException("High score can not exceed 50");
        }

        this.highScores.add(newHighScore);
    }
}
