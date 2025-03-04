package com.mazid.tournament_C.controller;

import com.mazid.tournament_C.dto.TeamDTO;
import com.mazid.tournament_C.model.Team;
import com.mazid.tournament_C.service.TeamService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/team")
public class TeamController {

    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @PostMapping("/create")
    public Team createTeam(@RequestBody Team team) {
        return teamService.createTeam(team);
    }

    @GetMapping("/list")
    public List<TeamDTO> getAllTeams() {
        return teamService.getAllTeams();
    }

    @PutMapping("/update/{teamId}")
    public Team updateTeam(@PathVariable Integer teamId, @RequestBody Team team) {
        return teamService.updateTeam(teamId, team);
    }

    @DeleteMapping("/delete/{teamId}")
    public String deleteTeam(@PathVariable Integer teamId) {
        return teamService.deleteTeam(teamId);
    }
}
