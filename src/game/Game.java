package game;

import java.util.Scanner;

public class Game {
	static Deck deck = new Deck(0);
	static Hand pHand = new Hand();
	static Hand dHand = new Hand();
	static Scanner kb = new Scanner(System.in);
	static String dHitOrStand = "S";
	static String pHitOrStand = "S";

	public static void main(String[] args) {
		run();

	}

	public static void run() {

		introduction();
		initialDeal();
		startGame();

	}

	public static void deal(Hand h, Deck d) {
		Card deal = d.dealHand();
		h.addCardToHand(deal);

	}

	public static void startGame() {
		System.out.println("The dealer has " + dHand + "Total: " + dHand.handValue());
		System.out.println("You have " + pHand + "Total: " + pHand.handValue());
		System.out.println("H) Hit\nS) Stand\n");

		dHitOrStand = "F";
		while (!(pHitOrStand.equals("S") && dHitOrStand.equals("S"))) {
			pHitOrStand = kb.next();
			switch (pHitOrStand) {
			case "H":
				playerTurn();
				dealerTurn();
				break;
			case "S":
				dealerTurn();
				break;
			}
		}
	}

	public static void playerTurn() {
		dealPlayer();
		// if (pHand)

	}

	public static void dealerTurn() {
		if (pHitOrStand.equals("S")) {
			while (dHand.handValue() <= 17) {
				System.out.println("Dealer will hit");
				dealDealer();
			}
		}
		System.out.println("Dealer is staying");
		dHitOrStand = "S";
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
