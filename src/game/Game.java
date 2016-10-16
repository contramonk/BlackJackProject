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
		deck = new Deck(0);
		pHand = new Hand();
		dHand = new Hand();
		pBust = false;
		dBust = false;
		player = new Player("def", pHand, 5000);
		dealer = new Dealer("tim", dHand, 5000);

		introduction();
		initialDeal();
		startGame();

	}

	public static void deal(Hand h, Deck d) {
		Card deal = d.dealHand();
		h.addCardToHand(deal);

	}

	public static void startGame() {
		System.out.println();
		System.out.println("Player");
		pHand.printHand();
		System.out.println("Total: " + pHand.handValue() + "\n");
		System.out.println();
		System.out.println("Dealer");
		dHand.printHand();
		System.out.println("Total: " + dHand.handValue());
		judgement();
// get rid of spade value 0
		dHitOrStand = "F";
		while (!(pHitOrStand.equals("S") && dHitOrStand.equals("S")) || (pBust && dBust)) {
			System.out.println();
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
		if (pHitOrStand.equals("S") && dHitOrStand.equals("S") || pBust == false || dBust == false) {
			judgement();
		}

	}

	public static void playerTurn() {
		dealPlayer();
		// if (pHand)

	}

	public static void dealerTurn() {
		while (dHand.handValue() < 17) {
			System.out.println("Dealer will hit");
			dealDealer();
			if (pHitOrStand.equals("H")) {
				playerTurn();
			}

		} // after loop finishes this prints causing duplication
		System.out.println();
		System.out.println("Dealer");
		System.out.println("Dealer Total: " + dHand.handValue());
		System.out.println("Dealer is staying \n");
		dHitOrStand = "S";
	}

	public static boolean dealPlayer() {
		deal(pHand, deck);
		System.out.println();
		System.out.println("Player");
		pHand.printHand();
		System.out.println("Hand Total: " + pHand.handValue());
		if (pHand.handValue() > 21) {
			System.out.println("Player Busted");
			pBust = true;
			judgement();
			return pBust;

		} else if (pHand.handValue() == 21) {
			judgement();
			return pBust;
		} else {
			return pBust;
		}
	}

	public static boolean dealDealer() {
		deal(dHand, deck);
		if (dHand.handValue() > 21) {
			System.out.println();
			System.out.println("Dealer");
			dHand.printHand();
			System.out.println("Dealer Total: " + dHand.handValue());
			System.out.println("Dealer busted");
			dBust = true;
			judgement();
			return dBust;
		} else if (dHand.handValue() == 21) {
			judgement();
			return dBust;
		} else {
			System.out.println();
			System.out.println("Dealer");
			dHand.printHand();
			System.out.println("Dealer Total: " + dHand.handValue());
			return dBust;
		}

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

	public static void judgement() {
		System.out.println();

		if (pBust) {
			System.out.println(dealer.getName() + " is the winner.");
			restart();
		} else if (dBust) {
			System.out.println(player.getName() + " is the winner.");
			restart();
		} else if (dHand.handValue() == 21) {
			System.out.println(dealer.getName() + " Dealer BLACKJACK.");
			restart();
		} else if (pHand.handValue() == 21) {
			System.out.println(player.getName() + " Player BLACKJACK.");
			restart();
		} else if (dHand.handValue() > pHand.handValue() && pHand.size() > 2 && dHand.size() > 2) {
			System.out.println(dealer.getName() + " is the winner");
			restart();
		} else if (pHand.handValue() > dHand.handValue() && pHand.size() > 2 && dHand.size() > 2) {
			System.out.println(player.getName() + " is the winner");
			restart();
		} else if (pHand.handValue() == dHand.handValue() && pHand.size() > 2 && dHand.size() > 2) {
			System.out.println(dealer.getName() + " is the winner.");

		}

	}


	public static void restart() {
		System.out.println("\nWould you like to play again (Y/N)?");
		String restart = kb.next();
		if (restart.equals("Y")) {
			run();
		} else {
			System.exit(1);
		}
	}
}
