package com.mazid.tournament_C.dto;

public class TeamDTO {
    private Integer teamId;
    private String teamName;

    public TeamDTO(Integer teamId, String teamName) {
        this.teamId = teamId;
        this.teamName = teamName;
    }

    public Integer getTeamId() { return teamId; }
    public String getTeamName() { return teamName; }
}
