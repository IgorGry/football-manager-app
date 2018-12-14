package com.bobocode.web.controller;

import com.bobocode.model.Player;
import com.bobocode.service.PlayerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

public class PlayerRestController {
    private final PlayerService playerService;

    public PlayerRestController(PlayerService playerService) {
        this.playerService = playerService;
    }
    @GetMapping
    public List<Player> getAll() {
        return playerService.getAll();
    }

    @GetMapping("/{id}")
    public Player getOne(@PathVariable long id) {
        return playerService.getOne(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Player player) {
        playerService.save(player);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable long id, @RequestBody Player player) {
        if (!Objects.equals(id, player.getId())) {
            throw new IllegalStateException("Id parameter does not match player body value");
        }
        playerService.save(player);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remove(@PathVariable long id) {
        Player player = playerService.getOne(id);
        playerService.remove(player);
    }
}
