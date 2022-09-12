package com.lld.games.snakeladdergame;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.lld.games.snakeladdergame.models.Board;
import com.lld.games.snakeladdergame.models.Dice;
import com.lld.games.snakeladdergame.models.Ladder;
import com.lld.games.snakeladdergame.models.Player;
import com.lld.games.snakeladdergame.models.Snake;
import com.lld.games.snakeladdergame.models.SpecialEntity;
import com.lld.games.snakeladdergame.service.Game;

@SpringBootApplication
public class SnakeLadderGameApplication {

	public static void main(String[] args) {
		SpringApplication.run(SnakeLadderGameApplication.class, args);

	}

	@PostConstruct
	public void run(){
		Snake snake = new Snake(26,13);
		Snake snake2 = new Snake(15, 10);
		Snake snake3 = new Snake(44,34);
		Ladder ladder = new Ladder(5,32);
		Ladder ladder2 = new Ladder(36, 55);
		Ladder ladder3 = new Ladder(23,47);
		List<SpecialEntity> specialEntities = Arrays.asList(snake,snake2,snake3,ladder,ladder2,ladder3);
		
		Player player = new Player("P1");
		Player player2 = new Player("P2");
		Player player3 = new Player("P3");
		Queue<Player> players = new LinkedList<>();
		players.addAll(Arrays.asList(player,player2,player3));

		Dice dice = new Dice(6);

		Board board = new Board(8,specialEntities);

		Game game = new Game();
		game.launchGame(board, dice, players);
		
	}
	

}
