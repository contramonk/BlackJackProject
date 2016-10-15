package game;

import java.util.Scanner;

public class Game {
	static Deck deck = new Deck(0);
	static Hand pHand = new Hand();
	static Hand dHand = new Hand();
	static Scanner kb = new Scanner(System.in);

	public static void main(String[] args) {
		run();

	}

	public static void run() {

		introduction();
		initialDeal();
		startGame();

		System.out.println(dHand);
		System.out.println(pHand);

	}

	public static void deal(Hand h, Deck d) {
		Card deal = d.dealHand();
		h.addCardToHand(deal);

	}

	public static void startGame() {
		String hitOrStand = "S";
		System.out.println("The dealer has " + dHand);
		System.out.println("You have " + pHand);
		System.out.println("H) Hit\nS) Stand\nQ) Quit");
		
		hitOrStand = kb.next();

		while (!hitOrStand.equals("Q")) {
			switch (hitOrStand) {
			case "H":
				dealDealer();
				playerTurn();
				System.out.println("H) Hit\nS) Stand\nQ) Quit");
				hitOrStand = kb.next();
				break;
			case "S":
				dealDealer();
				break;
			}
		}
	}
	public static void playerTurn() {
		dealPlayer();
		//if (pHand)
		
		
	}

	public static void dealPlayer() {
		deal(pHand, deck);
		System.out.println("Player: " + pHand + "\nHand Total: " + pHand.handValue());
	}

	public static void dealDealer() {
		deal(dHand, deck);
		System.out.println("Dealer: " + dHand + "\nDealer Total: " + dHand.handValue());

	}

	public static void initialDeal() {
		deck.addCardsToDeck();
		deal(pHand, deck);
		deal(dHand, deck);
		deal(pHand, deck);
		deal(dHand, deck);

	}

	public static void introduction() {

		System.out.println("Welcome to BlackJack.");
		System.out.println("What is your name?");
		String playerName = kb.next();
		Player player = new Player(playerName, pHand, 5000);

		System.out.println("What would you like your opponents name to be?");
		String dealerName = kb.next();
		Dealer dealer = new Dealer(dealerName, dHand, 5000);
		System.out.println(dealerName + " is dealing.");
	}
}
