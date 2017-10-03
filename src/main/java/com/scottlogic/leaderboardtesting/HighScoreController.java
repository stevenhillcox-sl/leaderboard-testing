package com.scottlogic.leaderboardtesting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api")
public class HighScoreController {

    private HighScoreRepository highScoreRepository;

    @Autowired
    public HighScoreController(HighScoreRepository highScoreRepository) {
        this.highScoreRepository = highScoreRepository;
    }

    @RequestMapping(value = "/highscores", method = RequestMethod.GET)
    public Collection<HighScore> getAllHighScores() {
        return highScoreRepository.getAllHighScores();
    }

    @RequestMapping(value = "/username/{userName}/highscores", method = RequestMethod.GET)
    public Collection<HighScore> getHighScoresForUserName(@PathVariable String userName) {
        return highScoreRepository.getScoresByUserName(userName);
    }

    @RequestMapping(value = "/gamename/{gameName}/highscores", method = RequestMethod.GET)
    public Collection<HighScore> getHighScoresForGameName(@PathVariable String gameName) {
        return highScoreRepository.getScoresByGameName(gameName);
    }

    @RequestMapping(value = "/highscores", method = RequestMethod.POST)
    public void post(@RequestBody @Validated HighScore highScore, BindingResult bindingResultt) {
        if(bindingResultt.hasErrors()) {
            throw new IllegalArgumentException();
        }
        highScoreRepository.add(highScore);
    }
}
