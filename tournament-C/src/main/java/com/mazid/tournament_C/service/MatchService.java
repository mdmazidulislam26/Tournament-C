package com.mazid.tournament_C.service;

import com.mazid.tournament_C.model.Match;
import com.mazid.tournament_C.repository.MatchRepository;
import org.springframework.stereotype.Service;

@Service
public class MatchService {

    private final MatchRepository matchRepository;

    public MatchService(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    public Match saveMatch(Match match) {
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
}
