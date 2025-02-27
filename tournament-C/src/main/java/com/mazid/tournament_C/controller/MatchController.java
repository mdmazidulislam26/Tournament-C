package com.mazid.tournament_C.controller;

import com.mazid.tournament_C.model.Match;
import com.mazid.tournament_C.service.MatchService;
import org.springframework.web.bind.annotation.*;

@RestController
public class MatchController {

    private final MatchService matchService;

    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @GetMapping("/home")
    public String initController() {
        return """
                <h1>Tournament C</h1>
                <h3>Please give me some information</h3>
                <ul>
                <li> First Team Name</li>
                <li> Second Team Name</li>
                <li> How many overs</li>
                <li> How many players in a team</li>
                <li> Match Date</li>
                </ul>""";
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
