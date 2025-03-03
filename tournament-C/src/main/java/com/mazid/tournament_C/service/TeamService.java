package com.mazid.tournament_C.service;

import com.mazid.tournament_C.dto.TeamDTO;
import com.mazid.tournament_C.exceptionHandler.NoDataFoundException;
import com.mazid.tournament_C.model.Team;
import com.mazid.tournament_C.repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {

    private final TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public Team createTeam(Team team) {
        if (team == null) {
            throw new IllegalArgumentException("Team object cannot be null");
        }
        String teamName = team.getTeamName();
        if (teamName == null || teamName.trim().isEmpty()) {
            throw new IllegalArgumentException("Team name cannot be null or empty");
        }
        team.setTeamName(teamName.substring(0, 1).toUpperCase() + teamName.substring(1));
        return teamRepository.save(team);
    }

    public List<TeamDTO> getAllTeams() {
        List<TeamDTO> teams = teamRepository.getAllTeamNames();
        if (teams == null || teams.isEmpty()) {
            throw new NoDataFoundException("No teams found in the database.");
        }
        return teams;
    }
}
