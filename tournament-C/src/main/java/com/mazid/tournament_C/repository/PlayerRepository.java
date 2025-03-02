package com.mazid.tournament_C.repository;

import com.mazid.tournament_C.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayerRepository extends JpaRepository<Player,Integer> {
    Optional<Player> findByPlayerEmail(String email);
    Optional<Player> findByUserName(String userName);
}


