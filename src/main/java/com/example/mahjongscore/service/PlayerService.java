package com.example.mahjongscore.service;

import com.example.mahjongscore.dao.Player;
import com.example.mahjongscore.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlayerService {
    @Autowired
    private PlayerRepository playerRepository;

    public Player createPlayer(Player player) {
        return playerRepository.save(player);
    }

    public Optional<Player> getPlayer(Long id) {
        return playerRepository.findById(id);
    }

    public void deletePlayer(Long id) {
        playerRepository.deleteById(id);
    }
}

