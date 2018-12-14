package com.bobocode.service;

import com.bobocode.dao.PlayerRepository;
import com.bobocode.model.Player;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

public class PlayerService {
    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public void save(Player player) {
        playerRepository.save(player);
    }

    @Transactional(readOnly = true)
    public List<Player> getAll() {
        return playerRepository.findAll();
    }

    public Player getOne(Long id) {
        return playerRepository.getOne(id);
    }

    public void update (Long id, Player player){
        if (!Objects.equals(id, player.getId())) {
            throw new IllegalStateException("Id parameter does not match account body value");
        }
        playerRepository.save(player);
    }

    public void remove (Player player){
        playerRepository.delete(player);
    }
}
