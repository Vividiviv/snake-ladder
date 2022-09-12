package com.lld.games.snakeladdergame.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Player {
    
    private String playerName;
    private int position;

    public Player(String playerName){
        this.playerName = playerName;
        this.position = 0; 
    }
    
}
