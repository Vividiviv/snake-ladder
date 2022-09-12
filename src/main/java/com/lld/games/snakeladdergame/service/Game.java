package com.lld.games.snakeladdergame.service;

import java.util.Queue;


import com.lld.games.snakeladdergame.models.*;

public class Game {

    Board board;
    Dice dice;
    Queue<Player> players;
    GameState gameState;

    public void initGame(Board board, Dice dice, Queue<Player> players){
        this.board = board;
        this.dice = dice;
        this.players = players;
        this.gameState = GameState.RUNNING;
    }

    public void launchGame(Board board, Dice dice, Queue<Player> players){
        
        initGame(board, dice, players);

        while (this.gameState == GameState.RUNNING){
            Player player = players.poll();
            Player updatedPlayer = givenPlayerPlaysGameAndMoves(player, board, dice);
            players.add(updatedPlayer);
        }

    }

    public Player givenPlayerPlaysGameAndMoves(Player player, Board board, Dice dice){
        System.out.println("Chance for player:"+player);
        int roll = dice.roll();
        int targetPosition = player.getPosition()+roll;
        System.out.println("The dice rolled a :"+roll);
        if(targetPosition>board.getDimension()*board.getDimension()){
            System.out.println("Invalid Roll!! Out of bounds");
            return player;
        }else{
            for(SpecialEntity specialEntity:board.getSpecialEntities()){
                if(targetPosition == specialEntity.getStartPos()){
                    if(specialEntity.getId().contains("S")){
                        System.out.println("Nooo !! Encountered a snake. Moving player:"+player.getPlayerName()+" to "+specialEntity.getEndPos());
                    }else {
                        System.out.println("Yaay !! Encountered a ladder. Moving player:"+player.getPlayerName()+" to "+specialEntity.getEndPos());
                    }
                targetPosition = specialEntity.getEndPos();
                }
            }
        }
    
        player.setPosition(targetPosition);
        if(checkWin(player,board.getDimension())){
            System.out.println("Player "+player.getPlayerName()+" wins the game");
            this.gameState=GameState.FINISHED;
            return player;
        }
        return player;
    }

    public Boolean checkWin(Player player, int dimension){
        if(player.getPosition() == (dimension*dimension)){
            return true;
        }
        return false;

    }
}
