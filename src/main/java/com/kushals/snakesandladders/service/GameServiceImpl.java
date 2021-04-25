package com.kushals.snakesandladders.service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import com.kushals.snakesandladders.enums.DiceTypes;
import com.kushals.snakesandladders.model.GameBoard;
import com.kushals.snakesandladders.model.Player;
import com.kushals.snakesandladders.model.Snake;

public class GameServiceImpl implements GameService{
	private GameBoard gameBoard;
	private Queue<Player> players;
	private boolean isGameFinished;
	private Map<Integer, Snake> snakesPositions;
	
	public GameServiceImpl(int boardSize) {
		this.gameBoard = new GameBoard(boardSize);
		this.players = new LinkedList<>();
		this.snakesPositions = new HashMap<>();
	}
	
	/**
	 * Sets the initial board with players positions
	 */
	public void setPlayerOnBoard(List<Player> players) {
		Map<String, Integer> playersPosition = new HashMap<>();
		for (Player player : players) {
			this.players.add(player);
			playersPosition.put(player.getId(), 0);
		}
		gameBoard.setPlayerPosition(playersPosition);
	}

	/**
	 * Sets snakes on board
	 * 
	 * @param snakes
	 * @param snakesPositions
	 */
	public void setSnakesOnBoard(List<Snake> snakes, Map<Integer, Snake> snakesPositions) {
		this.gameBoard.setSnakes(snakes);
		this.snakesPositions = snakesPositions;
	}

	/**
	 * gets new position for player
	 * 
	 * @param newPosition
	 * @return
	 */
	private int getNewPositionForPlayer(int newPosition) {

		if (this.snakesPositions.containsKey(newPosition)) {
			newPosition = this.snakesPositions.get(newPosition).getEnd();
			System.out.println("Snake is present at this position, moving player to new position: "+newPosition);
		}
		return newPosition;
	}

	/**
	 * moves player by given position
	 * 
	 * @param player
	 * @param newPosition
	 */
	private void movePlayer(Player player, int number) {
		int oldPosition = this.gameBoard.getPlayersPosition().get(player.getId());
		
		int newPosition = oldPosition + number;

		if (newPosition > this.gameBoard.getSize()) {
			System.out.println("New position goes out of board, no change in position for current player "+player.getName());
			return;
		} else {
			newPosition = this.getNewPositionForPlayer(newPosition);
		}
		this.gameBoard.getPlayersPosition().put(player.getId(), newPosition);
		System.out.println("Player " + player.getName() + " has rolled dice with number " + number + ", has moved to " + newPosition);
	}
	
	/**
	 * starts the game
	 */
	public void startGame() {
		while(!this.isGameFinished && !players.isEmpty()) {
			
			Player currentPlayer = players.poll();
			int rolledPosition = currentPlayer.getDice().roll();
			movePlayer(currentPlayer, rolledPosition);
			if(hasPlayerWon(currentPlayer)) {
				System.out.println("Player "+currentPlayer.getName()+ " has won the game");
				this.isGameFinished = true;
			} else if(!canPlayerEverWin(currentPlayer)) {
				// this player can never win for crooked dice
				System.out.println("Player "+currentPlayer.getName()+" can never win with crooked dice, hence lost");
				players.remove(currentPlayer);
			} else {
				players.add(currentPlayer);
			}
		}
	}
	
	/**
	 * Checks if player can ever win based on dice type
	 * @param player
	 * @return
	 */
	private boolean canPlayerEverWin(Player player) {
		return DiceTypes.CROOKED.getDiceType() == player.getDice() ? this.gameBoard.getPlayersPosition().get(player.getId()) % 2 == 0 : true;
	}
	
	/**
	 * decides if player has won
	 * @param player
	 * @return
	 */
	private boolean hasPlayerWon(Player player) {
		return this.gameBoard.getPlayersPosition().get(player.getId()) == this.gameBoard.getSize();
	}
	

}
