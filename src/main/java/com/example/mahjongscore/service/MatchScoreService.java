package com.example.mahjongscore.service;

import com.example.mahjongscore.dao.MatchScore;
import com.example.mahjongscore.repositories.MatchScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatchScoreService {
    @Autowired
    private MatchScoreRepository matchScoreRepository;

    public MatchScore addScore(MatchScore score) {
        return matchScoreRepository.save(score);
    }

    public Optional<MatchScore> getScore(Long id) {
        return matchScoreRepository.findById(id);
    }

    public List<MatchScore> getPlayerScores(Long playerId) {
        return matchScoreRepository.findByPlayerId(playerId);
    }

    public void deleteScore(Long id) {
        matchScoreRepository.deleteById(id);
    }

    public double calculatePlayerAverageScore(Long playerId) {
        List<MatchScore> scores = matchScoreRepository.findByPlayerId(playerId);

        return scores.stream()
                .mapToInt(MatchScore::getScore)
                .average()
                .orElse(0.0);  // If no scores exist, return 0
    }
}

