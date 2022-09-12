package com.lld.games.snakeladdergame.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Snake extends SpecialEntity{

    public Snake(int startPos, int endPos){
        this.startPos = startPos;
        this.endPos = endPos;
    }

    @Override
    public String getId(){
        return "S_"+this.endPos;
    }
    
}
