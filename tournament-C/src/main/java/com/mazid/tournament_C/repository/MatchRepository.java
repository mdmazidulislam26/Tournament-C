package com.mazid.tournament_C.repository;

import com.mazid.tournament_C.model.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatchRepository extends JpaRepository <Match, Integer>{

}
