package game;

import java.util.Scanner;

public class Game {
	static Deck deck = new Deck(0);
	static Hand pHand = new Hand();
	static Hand dHand = new Hand();
	static Scanner kb = new Scanner(System.in);
	static String dHitOrStand = "S";
	static String pHitOrStand = "S";
	static boolean dBust = false;
	static boolean pBust = false;
	static Player player = new Player("def", pHand, 5000);
	static Dealer dealer = new Dealer("tim", dHand, 5000);

	public static void main(String[] args) {
		run();

	}

	public static void run() {
		pBust = false;
		dBust = false;

		introduction();
		initialDeal();
		startGame();

	}

	public static void deal(Hand h, Deck d) {
		Card deal = d.dealHand();
		h.addCardToHand(deal);

	}

	public static void startGame() {
		System.out.println("Dealer");
		dHand.printHand();
		System.out.println("Total: " + dHand.handValue());
		System.out.println();
		System.out.println("Player");
		pHand.printHand();
		System.out.println("Total: " + pHand.handValue() + "\n");

		dHitOrStand = "F";
		while (!(pHitOrStand.equals("S") && dHitOrStand.equals("S")) || (pBust == false & dBust == false)) {
			System.out.println("H) Hit\nS) Stand\n");
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
		while (dHand.handValue() <= 17) {
			System.out.println("Dealer will hit");
			dealDealer();
		}
		System.out.println("Dealer");
		dHand.printHand();
		System.out.println("Dealer Total: " + dHand.handValue());
		System.out.println("Dealer is staying \n");
		dHitOrStand = "S";
	}

	public static boolean dealPlayer() {
		deal(pHand, deck);
		System.out.println("Player");
		pHand.printHand();
		System.out.println("Hand Total: " + pHand.handValue());
		if (pHand.handValue() > 21) {
			System.out.println("Player Busted");
			pBust = true;
			busted();
			restart();
			return pBust;

		} else {
			return pBust;
		}
	}

	public static boolean dealDealer() {
		deal(dHand, deck);
		if (dHand.handValue() > 21) {
			System.out.println("Dealer");
			dHand.printHand();
			System.out.println("Dealer Total: " + dHand.handValue());
			System.out.println("Dealer busted");
			dBust = true;
			busted();
			restart();
		} else {
			System.out.println("Dealer");
			dHand.printHand();
			System.out.println("Dealer Total: " + dHand.handValue());

		}

		return dBust;
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
		player.setName(playerName);

		System.out.println("What would you like your opponents name to be?");
		String dealerName = kb.next();
		dealer.setName(dealerName);

		System.out.println(dealerName + " is dealing.");

	}

	public static void busted() {
		System.out.println("checking 1 2 3");
		if (pBust) {
			System.out.println(dealer.getName() + " is the winner.");
		} else if (dBust) {
			System.out.println(player.getName() + " is the winner.");
		}
	}

	public static void restart() {
		System.out.println("\nWould you like to play again (Y/N)?");
		String restart = kb.next();
		if (restart.equals("Y")) {
			run();
		}
		else {
			System.exit(1);
		}
	}
}
