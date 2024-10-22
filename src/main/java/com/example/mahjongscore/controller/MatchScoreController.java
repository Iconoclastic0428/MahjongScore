package com.example.mahjongscore.controller;

import com.example.mahjongscore.dao.MatchScore;
import com.example.mahjongscore.service.MatchScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/scores")
public class MatchScoreController {
    @Autowired
    private MatchScoreService matchScoreService;

    @PostMapping
    public MatchScore addScore(@RequestBody MatchScore score) {
        return matchScoreService.addScore(score);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MatchScore> getScore(@PathVariable Long id) {
        return matchScoreService.getScore(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/player/{playerId}")
    public List<MatchScore> getPlayerScores(@PathVariable Long playerId) {
        return matchScoreService.getPlayerScores(playerId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteScore(@PathVariable Long id) {
        matchScoreService.deleteScore(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/player/{playerId}/average")
    public double getPlayerAverageScore(@PathVariable Long playerId) {
        return matchScoreService.calculatePlayerAverageScore(playerId);
    }
}

