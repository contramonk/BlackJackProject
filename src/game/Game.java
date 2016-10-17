package game;

import java.util.Scanner;

public class Game {
	static Deck deck = new Deck(0);
	static Hand pHand = new Hand();
	static Hand dHand = new Hand();
	static Scanner kb = new Scanner(System.in);
	static String dHitOrStand = "C";
	static String pHitOrStand = "C";
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
		dealer = new Dealer("def", dHand, 5000);
		dHitOrStand = "C";
		pHitOrStand = "C";

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
		System.out.println(player.getName() + " (Player)");
		System.out.println("----------------------------------------");
		pHand.printHand();
		System.out.println("----------------------------------------");
		System.out.println("Total: " + pHand.handValue());
		System.out.println("----------------------------------------");
		System.out.println();
		System.out.println(dealer.getName() + " (Dealer)");
		System.out.println("----------------------------------------");
		dHand.printHand();
		System.out.println("----------------------------------------");
		System.out.println("Total: " + dHand.handValue());
		System.out.println("----------------------------------------");
		judgement();

		dHitOrStand = "F";
		gameLoop();

		if (pHitOrStand.equals("S") && dHitOrStand.equals("S") || pBust == false || dBust == false) {
			judgement();
		}

	}
	public static void gameLoop() {
		while (!(pHitOrStand.equals("S") && dHitOrStand.equals("S")) || (pBust && dBust)) {
			System.out.println();
			System.out.print("H) Hit\nS) Stand >> ");
			pHitOrStand = kb.next();
			System.out.println();
			switch (pHitOrStand) {
			case "H":
				playerTurn();
				dealerTurn();
				break;
			case "S":
				dealerTurn();
				break;
			}
		} // end game loop
		
	}

	public static void playerTurn() {
		dealPlayer();

	}

	public static void dealerTurn() {
		while (dHand.handValue() < 17) {
			System.out.println();
			System.out.println(dealer.getName() + " (Dealer) will hit");
			dealDealer();
			if (pHitOrStand.equals("H")) { // player auto hit bug
				gameLoop();
			}

		} // after loop finishes this prints causing duplication
		System.out.println();
		System.out.println(player.getName() + " (Dealer)");
		System.out.println("Dealer Total: " + dHand.handValue());
		System.out.println("Dealer is staying \n");
		dHitOrStand = "S";
	}

	public static boolean dealPlayer() {
		deal(pHand, deck);
		System.out.println();
		System.out.println(player.getName() + " (Player)");
		System.out.println("----------------------------------------");
		pHand.printHand();
		System.out.println("----------------------------------------");
		System.out.println("Hand Total: " + pHand.handValue());
		System.out.println("----------------------------------------");
		if (pHand.handValue() > 21) {
			System.out.println("~~~Player Busted~~~");
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
			System.out.println(dealer.getName() + "(Dealer)");
			System.out.println("----------------------------------------");
			dHand.printHand();
			System.out.println("----------------------------------------");
			System.out.println("Dealer Total: " + dHand.handValue());
			System.out.println("----------------------------------------");
			System.out.println("~~~Dealer busted~~~");
			dBust = true;
			judgement();
			return dBust;
		} else if (dHand.handValue() == 21) {
			judgement();
			return dBust;
		} else {
			System.out.println();
			System.out.println(dealer.getName() + "(Dealer)");
			System.out.println("----------------------------------------");
			dHand.printHand();
			System.out.println("----------------------------------------");
			System.out.println("Dealer Total: " + dHand.handValue());
			System.out.println("----------------------------------------");
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
		System.out.print("What is your name? >> ");
		String playerName = kb.next();
		player.setName(playerName);
		System.out.println();
		System.out.print(playerName + ",  what is your opponents name? >> ");
		String dealerName = kb.next();
		dealer.setName(dealerName);
		System.out.println();
		System.out.println(dealerName + " is dealing.");

	}

	public static void judgement() {
		System.out.println();

		if (pBust) {
			System.out.println("****** " + dealer.getName() + " is the winner. ******");
			restart();
		} else if (dBust) {
			System.out.println("****** " + player.getName() + " is the winner. ******");
			restart();
		} else if (dHand.handValue() == 21) {
			System.out.println("****** " + dealer.getName() + " has BLACKJACK. ******");
			restart();
		} else if (pHand.handValue() == 21) {
			System.out.println("****** " + player.getName() + " has BLACKJACK. ******");
			restart();
		} else if (dHand.handValue() > pHand.handValue() && pHitOrStand.equals("S") && dHitOrStand.equals("S")) {
			System.out.println("****** " + dealer.getName() + " is the winner. ******");
			restart();
		} else if (pHand.handValue() > dHand.handValue() && pHitOrStand.equals("S") && dHitOrStand.equals("S")) {
			System.out.println(" ****** " + player.getName() + " is the winner. ******");
			restart();
		} else if (pHand.handValue() == dHand.handValue() && pHitOrStand.equals("S") && dHitOrStand.equals("S")) {
			System.out.println("****** " + dealer.getName() + " is the winner. ******");
			restart();
		}

	}


	public static void restart() {
		System.out.print("\nWould you like to play again (Y/N)? >> ");
		String restart = kb.next();
		if (restart.equals("Y")) {
			run();
		} else {
			System.exit(1);
		}
	}
}
