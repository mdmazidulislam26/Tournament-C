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
        teamName = teamName.toLowerCase();
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

    public Team updateTeam(Integer teamId, Team team) {
        Team existingTeam = teamRepository.findById(teamId).orElse(null);
        if (existingTeam == null) {
            throw new NoDataFoundException("Team not found with ID: " + teamId);
        }

        boolean update = false;

        if (team.getTeamName() != null
                && !team.getTeamName().isBlank()
                && !(team.getTeamName().substring(0, 1).toUpperCase() + team.getTeamName().substring(1).toLowerCase()).equals(existingTeam.getTeamName())
        ) {
            System.out.println(1);
            existingTeam.setTeamName(team.getTeamName().substring(0, 1).toUpperCase() + team.getTeamName().substring(1).toLowerCase());
            update = true;
        }


        if (team.getPlayer1() != null && !team.getPlayer1().isBlank() && !team.getPlayer1().equals(existingTeam.getPlayer1())) {
            existingTeam.setPlayer1(team.getPlayer1().substring(0, 1).toUpperCase() + team.getPlayer1().substring(1).toLowerCase());
            update = true;
        }

        if (team.getPlayer2() != null && !team.getPlayer2().isBlank() && !team.getPlayer2().equals(existingTeam.getPlayer2())) {
            existingTeam.setPlayer2(team.getPlayer2().substring(0, 1).toUpperCase() + team.getPlayer2().substring(1).toLowerCase());
            update = true;
        }

        if (team.getPlayer3() != null && !team.getPlayer3().isBlank() && !team.getPlayer3().equals(existingTeam.getPlayer3())) {
            existingTeam.setPlayer3(team.getPlayer3().substring(0, 1).toUpperCase() + team.getPlayer3().substring(1).toLowerCase());
            update = true;
        }

        if (team.getPlayer4() != null && !team.getPlayer4().isBlank() && !team.getPlayer4().equals(existingTeam.getPlayer4())) {
            existingTeam.setPlayer4(team.getPlayer4().substring(0, 1).toUpperCase() + team.getPlayer4().substring(1).toLowerCase());
            update = true;
        }

        if (team.getPlayer5() != null && !team.getPlayer5().isBlank() && !team.getPlayer5().equals(existingTeam.getPlayer5())) {
            existingTeam.setPlayer5(team.getPlayer5().substring(0, 1).toUpperCase() + team.getPlayer5().substring(1).toLowerCase());
            update = true;
        }

        if (team.getPlayer6() != null && !team.getPlayer6().isBlank() && !team.getPlayer6().equals(existingTeam.getPlayer6())) {
            existingTeam.setPlayer6(team.getPlayer6().substring(0, 1).toUpperCase() + team.getPlayer6().substring(1).toLowerCase());
            update = true;
        }

        if (team.getPlayer7() != null && !team.getPlayer7().isBlank() && !team.getPlayer7().equals(existingTeam.getPlayer7())) {
            existingTeam.setPlayer7(team.getPlayer7().substring(0, 1).toUpperCase() + team.getPlayer7().substring(1).toLowerCase());
            update = true;
        }

        if (team.getPlayer8() != null && !team.getPlayer8().isBlank() && !team.getPlayer8().equals(existingTeam.getPlayer8())) {
            existingTeam.setPlayer8(team.getPlayer8().substring(0, 1).toUpperCase() + team.getPlayer8().substring(1).toLowerCase());
            update = true;
        }

        if (team.getPlayer9() != null && !team.getPlayer9().isBlank() && !team.getPlayer9().equals(existingTeam.getPlayer9())) {
            existingTeam.setPlayer9(team.getPlayer9().substring(0, 1).toUpperCase() + team.getPlayer9().substring(1).toLowerCase());
            update = true;
        }

        if (team.getPlayer10() != null && !team.getPlayer10().isBlank() && !team.getPlayer10().equals(existingTeam.getPlayer10())) {
            existingTeam.setPlayer10(team.getPlayer10().substring(0, 1).toUpperCase() + team.getPlayer10().substring(1).toLowerCase());
            update = true;
        }

        if (team.getPlayer11() != null && !team.getPlayer11().isBlank() && !team.getPlayer11().equals(existingTeam.getPlayer11())) {
            existingTeam.setPlayer11(team.getPlayer11().substring(0, 1).toUpperCase() + team.getPlayer11().substring(1).toLowerCase());
            update = true;
        }

        if (team.getTeamCaptain() != null && !team.getTeamCaptain().isBlank() && !team.getTeamCaptain().equals(existingTeam.getTeamCaptain())) {
            existingTeam.setTeamCaptain(team.getTeamCaptain().substring(0, 1).toUpperCase() + team.getTeamCaptain().substring(1).toLowerCase());
            update = true;
        }

        if (update)return teamRepository.save(existingTeam);

        return existingTeam;
    }
}
