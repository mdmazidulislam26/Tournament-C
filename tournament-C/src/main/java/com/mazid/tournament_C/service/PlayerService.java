package com.mazid.tournament_C.service;

import com.mazid.tournament_C.model.Player;
import com.mazid.tournament_C.repository.PlayerRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
//@Validated
public class PlayerService {

    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public Player createPlayer(Player player) {
        if (player == null) {
            throw new IllegalArgumentException("Player object cannot be null");
        }
        if (player.getPlayerName() == null || player.getPlayerName().trim().isEmpty()) {
            throw new IllegalArgumentException("Player name cannot be null or empty");
        }
        if (player.getUserName() == null || player.getUserName().trim().isEmpty()) {
            throw new IllegalArgumentException("Player User name cannot be null or empty");
        }
        player.setUserName(player.getUserName().toLowerCase());
        if (player.getPlayerEmail() == null || player.getPlayerEmail().trim().isEmpty()) {
            throw new IllegalArgumentException("Player email cannot be null or empty");
        }
        if (!player.getPlayerEmail().matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")) {
            throw new IllegalArgumentException("Invalid email format");
        }
        player.setPlayerEmail(player.getPlayerEmail().toLowerCase());
        if (player.getDOB() == null) {
            throw new IllegalArgumentException("Date of birth cannot be null");
        }
        Optional<Player> existingPlayerByEmail = playerRepository.findByPlayerEmail(player.getPlayerEmail());
        Optional<Player> existingPlayerByUsername = playerRepository.findByUserName(player.getUserName());

        if (existingPlayerByEmail.isPresent()) {
            throw new DataIntegrityViolationException("Email already exists!");
        }
        if (existingPlayerByUsername.isPresent()) {
            throw new DataIntegrityViolationException("Username already exists!");
        }


        return playerRepository.save(player);
    }

    public List<Player> getPlayerList() {
        return playerRepository.findAll();
    }

    public Player getPlayer(Integer playerId) {
        return playerRepository.findById(playerId)
                .orElseThrow(() -> new IllegalArgumentException("Player not found with ID: " + playerId));
    }

    public Player updatePlayer(Integer playerId, Player updatedPlayer) {
        Player existingPlayer = playerRepository.findById(playerId)
                .orElseThrow(() -> new IllegalArgumentException("Player not found with ID: " + playerId));

        boolean update = false;

        if (updatedPlayer.getUserName() != null && !updatedPlayer.getUserName().isEmpty()) {
            throw new IllegalArgumentException("Username cannot be updated!");
        }

        if (updatedPlayer.getPlayerName() != null
                && !updatedPlayer.getPlayerName().isBlank()
                && !updatedPlayer.getPlayerName().equals(existingPlayer.getPlayerName())) {
            existingPlayer.setPlayerName(updatedPlayer.getPlayerName());
            update = true;
        }

        if (updatedPlayer.getPlayerEmail() != null && !updatedPlayer.getPlayerEmail().isBlank()
                && !updatedPlayer.getPlayerEmail().equalsIgnoreCase(existingPlayer.getPlayerEmail())) {
            if (!updatedPlayer.getPlayerEmail().matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")) {
                throw new IllegalArgumentException("Invalid email format");
            }
            existingPlayer.setPlayerEmail(updatedPlayer.getPlayerEmail().toLowerCase());
            update = true;
        }


        if (updatedPlayer.getDOB() != null && !updatedPlayer.getDOB().equals(existingPlayer.getDOB())) {
            existingPlayer.setDOB(updatedPlayer.getDOB());
            update = true;
        }

        if (update) return playerRepository.save(existingPlayer);
        return existingPlayer;
    }

    public String deletePlayer(Integer playerId) {
        playerRepository.deleteById(playerId);
        return "Player id " + playerId + " deleted successfully!";
    }



}
