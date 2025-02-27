package com.mazid.tournament_C.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "matches")
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer matchId;
    private String firstTeam ;
    private String secondTeam;
    private Integer plays;
    private Integer overs;
    private String matchName = firstTeam + " vs " + secondTeam;
}
