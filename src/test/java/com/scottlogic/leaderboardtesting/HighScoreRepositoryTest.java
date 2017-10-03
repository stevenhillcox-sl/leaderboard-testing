package com.scottlogic.leaderboardtesting;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertTrue;

public class HighScoreRepositoryTest {

    @Test
    public void new_Repository_Is_Empty() {
        HighScoreRepository repository = new HighScoreRepository();

        Collection<HighScore> highScores = repository.getAllHighScores();

        assertTrue(highScores.isEmpty());
    }

    @Test
    public void getAllHighScores_Gets_Sorted_High_Scores() {
        HighScore score1 = new HighScore("Test", "Test", 1);
        HighScore score2 = new HighScore("Test2", "Test2", 2);
        HighScore score3 = new HighScore("Test3", "Test3", 3);
        Collection<HighScore> testHighScores = Arrays.asList(score1, score2, score3);
        HighScoreRepository repository = new HighScoreRepository(testHighScores);

        Collection<HighScore> highScores = repository.getAllHighScores();

        Collection<HighScore> expectedHighScores = Arrays.asList(score3, score2, score1);
        Assert.assertEquals(expectedHighScores, highScores);
    }

    @Test
    public void getScoresByUserName_Gets_Sorted_High_Scores_For_UserName() {
        HighScore score1 = new HighScore("Test", "Test", 1);
        HighScore score2 = new HighScore("Test2", "Test2", 2);
        HighScore score3 = new HighScore("Test3", "Test3", 3);
        HighScore score4 = new HighScore("Test3", "Test4", 2);
        Collection<HighScore> testHighScores = Arrays.asList(score1, score2, score3, score4);
        HighScoreRepository repository = new HighScoreRepository(testHighScores);

        Collection<HighScore> highScores = repository.getScoresByUserName("Test3");

        Collection<HighScore> expectedHighScores = Arrays.asList(score3, score4);
        Assert.assertEquals(expectedHighScores, highScores);
    }

    @Test
    public void getScoresByGameName_Gets_Sorted_High_Scores_For_GameName() {
        HighScore score1 = new HighScore("Test", "Test", 1);
        HighScore score2 = new HighScore("Test2", "Test2", 2);
        HighScore score3 = new HighScore("Test3", "Test3", 3);
        HighScore score4 = new HighScore("Test4", "Test3", 2);
        Collection<HighScore> testHighScores = Arrays.asList(score1, score2, score3, score4);
        HighScoreRepository repository = new HighScoreRepository(testHighScores);

        Collection<HighScore> highScores = repository.getScoresByGameName("Test3");

        Collection<HighScore> expectedHighScores = Arrays.asList(score3, score4);
        Assert.assertEquals(expectedHighScores, highScores);
    }

    @Test
    public void add_Adds_New_HighScore() {
        HighScore score1 = new HighScore("Test", "Test", 1);
        HighScore score2 = new HighScore("Test2", "Test2", 2);

        HighScore score3 = new HighScore("Test3", "Test3", 3);

        Collection<HighScore> testHighScores = Arrays.asList(score1, score2);
        HighScoreRepository repository = new HighScoreRepository(testHighScores);

        repository.add(score3);
        Collection<HighScore> highScores = repository.getAllHighScores();

        Collection<HighScore> expectedHighScores = Arrays.asList(score3, score2, score1);
        Assert.assertEquals(expectedHighScores, highScores);
    }
}
