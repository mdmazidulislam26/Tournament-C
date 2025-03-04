package com.mazid.tournament_C.controller;

import com.mazid.tournament_C.dto.TeamDTO;
import com.mazid.tournament_C.model.Team;
import com.mazid.tournament_C.service.TeamService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/TeamList")
    public List<TeamDTO> getAllTeams() {
        return teamService.getAllTeams();
    }

    @PutMapping("/UpdateTeam/{teamId}")
    public Team updateTeam(@PathVariable Integer teamId, @RequestBody Team team) {
        return teamService.updateTeam(teamId, team);

    }
}
