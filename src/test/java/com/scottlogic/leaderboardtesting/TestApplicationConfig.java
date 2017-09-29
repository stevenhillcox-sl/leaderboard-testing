package com.scottlogic.leaderboardtesting;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication
public class TestApplicationConfig {

    public ArrayList<HighScore> testHighScores = new ArrayList<>(Arrays.asList(
        new HighScore("Test1", "Test1",20),
        new HighScore("Test2", "Test2", 27),
        new HighScore("Test3", "Test3", 12)));

    @Bean
    public HighScoreRepository getScoreRepository() {
        return new HighScoreRepository(testHighScores);
    }
}
