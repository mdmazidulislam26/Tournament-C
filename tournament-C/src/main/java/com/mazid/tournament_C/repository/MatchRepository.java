package com.mazid.tournament_C.repository;

import com.mazid.tournament_C.dto.MatchDTO;
import com.mazid.tournament_C.model.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatchRepository extends JpaRepository <Match, Integer>{
    @Query("SELECT new com.mazid.tournament_C.dto.MatchDTO(m.matchId, m.matchName, m.date) FROM Match m")
    List<MatchDTO> findAllMatches();
}
