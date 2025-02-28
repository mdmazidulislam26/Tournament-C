package com.mazid.tournament_C.service;

import com.mazid.tournament_C.model.Match;
import com.mazid.tournament_C.repository.MatchRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class MatchService {

    private final MatchRepository matchRepository;

    public MatchService(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    public Match createMatch(Match match) {
        if (match == null) {
            throw new IllegalArgumentException("Match object cannot be null");
        }
        if (match.getFirstTeam() == null || match.getFirstTeam().trim().isEmpty()) {
            throw new IllegalArgumentException("First team name cannot be null or empty");
        }
        if (match.getSecondTeam() == null || match.getSecondTeam().trim().isEmpty()) {
            throw new IllegalArgumentException("Second team name cannot be null or empty");
        }
        if (match.getPlays() == null || match.getPlays() <= 0) {
            throw new IllegalArgumentException("Number of players (plays) must be greater than 0");
        }
        if (match.getOvers() == null || match.getOvers() <= 0) {
            throw new IllegalArgumentException("Overs must be greater than 0");
        }
        if (match.getDate() == null) {
            throw new IllegalArgumentException("Match date cannot be null");
        }

        match.generateMatchName();
        match.validateMatchDate();

        return matchRepository.save(match);
    }

    public Match updateMatch(Integer matchId, Match match) {

        match.validateMatchDate();

        return matchRepository.findById(matchId)
                .map(existingMatch -> {
                    if (match.getPlays() != null && match.getPlays() > 0) {
                        existingMatch.setPlays(match.getPlays());
                    }
                    if (match.getDate() != null) {
                        existingMatch.setDate(match.getDate());
                    }
                    return matchRepository.save(existingMatch);
                })
                .orElseThrow(() -> new NoSuchElementException("Match with ID " + matchId + " not found!"));
    }

    public String deleteMatch(Integer matchId) {
        Optional<Match> matchOptional = matchRepository.findById(matchId);

        if (matchOptional.isEmpty()) {
            throw new NoSuchElementException("Match with ID " + matchId + " not found!");
        }

        matchRepository.deleteById(matchId);
        return "Match deleted successfully";
    }
}
