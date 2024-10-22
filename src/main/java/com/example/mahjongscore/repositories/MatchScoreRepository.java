package com.example.mahjongscore.repositories;

import com.example.mahjongscore.dao.MatchScore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatchScoreRepository extends JpaRepository<MatchScore, Long> {
    List<MatchScore> findByPlayerId(Long playerId);
}

