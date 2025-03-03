package com.mazid.tournament_C.controller;

import com.mazid.tournament_C.model.Team;
import com.mazid.tournament_C.service.TeamService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeamController {

    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @PostMapping("/CreateTeam")
    public Team createTeam(@RequestBody Team team) {
        return teamService.createTeam(team);
    }
}
