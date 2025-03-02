package com.mazid.tournament_C.controller;

import com.mazid.tournament_C.model.Player;
import com.mazid.tournament_C.service.PlayerService;
import org.springframework.web.bind.annotation.*;

@RestController
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping("/CreatePlayer")
    public Player createPlayer(@RequestBody Player player) {
        return playerService.createPlayer(player);
    }

    @PutMapping("/UpdatePlayer/{playerId}")
    public Player updatePlayer(@PathVariable Integer playerId, @RequestBody Player player) {
        return playerService.updatePlayer(playerId, player);
    }

    @DeleteMapping("/DeletePlayer/{playerId}")
    public String deletePlayer(@PathVariable Integer playerId) {
        return playerService.deletePlayer(playerId);
    }
}
