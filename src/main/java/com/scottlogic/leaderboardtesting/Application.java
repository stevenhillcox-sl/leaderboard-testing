package com.scottlogic.leaderboardtesting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public HighScoreRepository getScoreRepository() {
        return new HighScoreRepository(Arrays.asList(
            new HighScore("Jim", "Miracle Rainbow Beatdown",20),
            new HighScore("Sue", "Covfefe Fighter", 27),
            new HighScore("Rob", "Covfefe Fighter", 12),
            new HighScore("Bob", "Royal Pachinko Scam",36),
            new HighScore("Ann", "Telekinetic Shark 2",48),
            new HighScore("Kim", "Telekinetic Shark 2",15),
            new HighScore("Dan", "Battlefield: Squirrel",32)
        ));
    }
}
