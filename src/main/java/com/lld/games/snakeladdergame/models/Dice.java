package com.lld.games.snakeladdergame.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class Dice {
    
    private int maxValue;

    public int roll(){
        return (int)(Math.random()*maxValue);
    }
}
