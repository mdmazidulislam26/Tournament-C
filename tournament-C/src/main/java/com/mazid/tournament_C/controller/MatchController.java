package com.mazid.tournament_C.controller;

import com.mazid.tournament_C.model.Match;
import com.mazid.tournament_C.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class MatchController {

    @Autowired
    private MatchService matchService;

    @GetMapping("/home")
    private String InitController(){
        return """
                <h1>Tournament C</h1>\
                <h3>Please give me some information</h3>\
                <ul> \
                <li> First Team Name</li>\
                <li> Second Team Name</li>\
                <li> How many overs</li>\
                <li> How many plays in a team</li>\
                </ul>""";
    }

  @PostMapping("/match")
  private Match match(@RequestBody Match match) {
      return matchService.saveMatchDetails(match);
  }
}
