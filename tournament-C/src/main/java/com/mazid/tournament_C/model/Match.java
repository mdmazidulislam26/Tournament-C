package com.mazid.tournament_C.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mazid.tournament_C.exceptionHandler.ExpiredDateException;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "matches")
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer matchId;
    private String matchName;
    private String firstTeam;
    private String secondTeam;
    private Integer plays;
    private Integer overs;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate date;

    public void validateMatchDate() {
        if (date != null && date.isBefore(LocalDate.now())) {
            throw new ExpiredDateException("Match date cannot be in the past!");
        }
    }

    public void generateMatchName() {
        this.matchName = firstTeam + " vs " + secondTeam;
    }
}
