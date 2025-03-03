package com.mazid.tournament_C.repository;

import com.mazid.tournament_C.dto.TeamDTO;
import com.mazid.tournament_C.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamRepository extends JpaRepository<Team, Integer> {

    @Query("SELECT new com.mazid.tournament_C.dto.TeamDTO(t.teamId, t.teamName) FROM Team t ORDER BY t.teamId ASC")
    List<TeamDTO> getAllTeamNames();



}
