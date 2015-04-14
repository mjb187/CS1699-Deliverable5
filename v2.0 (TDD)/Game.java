//Code refactored by Mike Byrne
//	mjb187@pitt.edu

// CHANGES
//	- fixed bug where 'n' is not a recognized input
//	- fixed bug where there is no Help menu
//	- adapted doSomething() to accept the numerical representation of a win condition from the Player class

import java.util.Scanner;

public class Game {

	private Player _player = null;
	private House _house = null;
	
	public Game(Player p, House h) {
		_player = p;
		_house = h;
	}
	
	public int doSomething(String move) {
		int toReturn = 0;
		if (move.equalsIgnoreCase("N")) {
			_house.moveNorth();
		} else if (move.equalsIgnoreCase("S")) {
			_house.moveSouth();
		} else if (move.equalsIgnoreCase("L")) {
			_house.look(_player);
		} else if (move.equalsIgnoreCase("I")) {
			_player.showInventory();
		} else if (move.equalsIgnoreCase("H")) {
			helpMenu();
		} else if (move.equalsIgnoreCase("D")) {
			int finalStatus = _player.drink();
			if (finalStatus == 111) {
				toReturn = 1;
			} else {
				toReturn = -1;
			}
		} else {
			System.out.println("What?");
		}
		return toReturn;
	}
	
	public void helpMenu() {
		System.out.println("Game Commands:");
		System.out.println("\tN: move north");
		System.out.println("\tS: move south");
		System.out.println("\tL: look around the room");
		System.out.println("\tI: check inventory");
		System.out.println("\tH: open help menu");
		System.out.println("\tD: drink your coffee!");
	}
	
	public int run() {
		int toReturn = 0;
		
		Scanner in = new Scanner(System.in);
		String move = null;
		
		boolean gameOver = false;
		boolean win = false;
		
		while (!gameOver) {
			System.out.println(_house.getCurrentRoomInfo());
			System.out.println(" INSTRUCTIONS (N,S,L,I,H,D) > ");
			move = in.nextLine();
			int status = doSomething(move);
			if (status == 1) {
				gameOver = true;
				win = true;
			} else if (status == -1) {
				gameOver = true;
				win = false;
			}
		}
		
		if (win) {
			System.out.println("You win!");
			toReturn = 0;
		} else {
			System.out.println("You lose!");
			toReturn = 1;
		}
		
		return toReturn;
	}
	
}
