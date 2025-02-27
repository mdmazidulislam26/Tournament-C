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
                .orElseThrow(() -> new IllegalArgumentException("Match with ID " + matchId + " not found!"));
    }


    public String deleteMatch(Integer matchId) {
        if (matchRepository.findById(matchId).isPresent()){
            matchRepository.deleteById(matchId);
            return "Match delete successful";
        }
        return "Match not successful";
    }
}
