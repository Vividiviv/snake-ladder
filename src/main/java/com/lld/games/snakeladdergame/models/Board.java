package com.lld.games.snakeladdergame.models;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Board {
    private int dimension;
    private List<SpecialEntity> specialEntities;

    public void printBoard(){
        int count=0;
        for(int i =0; i<this.dimension*this.dimension;i++){
                int flag=0;
                for(SpecialEntity specialEntity:specialEntities){
                    if(i==specialEntity.startPos || i==specialEntity.endPos){
                        System.out.print(specialEntity.getId()+" ");
                        flag=1;
                    }
                }
                count++;
                if(flag==0)
                    System.out.print(count + " ");
                if(count%dimension==0)  {  
                    System.out.println();
                }
        }
    }
}
