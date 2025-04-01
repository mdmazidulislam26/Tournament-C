package com.mazid.tournament_C.controller

import com.mazid.tournament_C.dto.MatchDTO;
import com.mazid.tournament_C.model.Match;
import com.mazid.tournament_C.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/match")
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
    public List<MatchDTO> getAllMatches() {
        return matchService.getAllMatches();
    }

    @PostMapping("/create")
    public Match createMatch(@RequestBody Match match) {
        return matchService.createMatch(match);
    }

    @PutMapping("/update/{matchId}")
    public Match updateMatch(@PathVariable Integer matchId, @RequestBody Match match) {
        return matchService.updateMatch(matchId,match);
    }

    @DeleteMapping("/delete/{matchId}")
    public String deleteMatch(@PathVariable Integer matchId){
        return matchService.deleteMatch(matchId);
    }


}
