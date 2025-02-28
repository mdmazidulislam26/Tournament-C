package com.mazid.tournament_C.controller;

import com.mazid.tournament_C.model.Match;
import com.mazid.tournament_C.service.MatchService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MatchController {

    private final MatchService matchService;

    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @GetMapping("/")
    public String initController() {
        return """
                <h1>Tournament C</h1>
                <h3>Please give me some information</h3>
                <ul>
                <li> First Team Name</li>
                <li> Second Team Name</li>
                <li> Match Date</li>
                </ul>""";
    }

    @GetMapping("/home")
    public List<Match> getAllMatches() {
        return matchService.home(); // Fetch all matches from DB
    }

    @PostMapping("/CreateMatch")
    public Match createMatch(@RequestBody Match match) {
        return matchService.createMatch(match);
    }

    @PutMapping("/UpdateMatch/{matchId}")
    public Match updateMatch(@PathVariable Integer matchId, @RequestBody Match match) {
        return matchService.updateMatch(matchId,match);
    }

    @DeleteMapping("/DeleteMatch/{matchId}")
    public String deleteMatch(@PathVariable Integer matchId){
        return matchService.deleteMatch(matchId);
    }


}
