package com.scottlogic.leaderboardtesting;

import org.junit.Test;
import org.springframework.validation.BindingResult;

import static org.mockito.Mockito.*;

public class HighScoreControllerTest {

    @Test
    public void getAllHighScores_Calls_Repo_GetAllHighScores() {
        HighScoreRepository mockRepo = mock(HighScoreRepository.class);
        HighScoreController controller = new HighScoreController(mockRepo);

        controller.getAllHighScores();

        verify(mockRepo).getAllHighScores();
    }

    @Test
    public void getHighScoresForGameName_Calls_Repo_GetScoresByGameName() {
        HighScoreRepository mockRepo = mock(HighScoreRepository.class);
        HighScoreController controller = new HighScoreController(mockRepo);
        String gameName = "test";

        controller.getHighScoresForGameName(gameName);

        verify(mockRepo).getScoresByGameName(eq(gameName));
    }

    @Test
    public void getHighScoresForUserName_Calls_Repo_GetScoresByUserName() {
        HighScoreRepository mockRepo = mock(HighScoreRepository.class);
        HighScoreController controller = new HighScoreController(mockRepo);
        String userName = "test";

        controller.getHighScoresForUserName(userName);

        verify(mockRepo).getScoresByUserName(eq(userName));
    }

    @Test
    public void post_Calls_Repo_Add() {
        HighScoreRepository mockRepo = mock(HighScoreRepository.class);
        HighScoreController controller = new HighScoreController(mockRepo);
        HighScore highScore = new HighScore("test", "test", 1);

        controller.post(highScore, mock(BindingResult.class));

        verify(mockRepo).add(eq(highScore));
    }
}