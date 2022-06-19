package com.example.SoccerJava.domain;

import com.example.SoccerJava.validation.AddGroup;
import com.example.SoccerJava.validation.SetGroup;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Player {

    @NotNull(groups = {SetGroup.class})
    private Long playerId;

    @NotBlank(groups = {AddGroup.class, SetGroup.class})
    @Size(min = 1, max = 30, groups = {AddGroup.class,SetGroup.class})
    private String playerName;

    public Long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
}
