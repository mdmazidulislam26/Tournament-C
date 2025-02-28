package com.mazid.tournament_C.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;

public class MatchDTO {
    private Integer matchId;
    private String matchName;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy") // Ensure Date Format
    private LocalDate date;

    public MatchDTO(Integer matchId, String matchName, LocalDate date) {
        this.matchId = matchId;
        this.matchName = matchName;
        this.date = date;
    }

    public Integer getMatchId() {
        return matchId;
    }

    public String getMatchName() {
        return matchName;
    }

    public LocalDate getDate() {
        return date;
    }
}
