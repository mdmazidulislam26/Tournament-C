package com.mazid.tournament_C.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mazid.tournament_C.exceptionHandler.ExpiredDateException;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "players", uniqueConstraints = {
        @UniqueConstraint(columnNames = "playerEmail"),
        @UniqueConstraint(columnNames = "userName")
})
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer playerId;
    private String playerName;
    private String playerEmail;
    private String userName;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate DOB;

    public void validateMatchDate() {
        if (DOB != null && DOB.isAfter(LocalDate.now())) {
            throw new ExpiredDateException("Match date cannot be in the future!");
        }
    }
}
