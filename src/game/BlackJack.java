package game;

import java.util.Scanner;

 public class BlackJack {
	
	private Deck deck = new Deck();
	private Hand pHand = new Hand();
	private Hand dHand = new Hand();
	private Scanner kb = new Scanner(System.in);
	private String dHitOrStand = "C";
	private String pHitOrStand = "C";
	private boolean dBust = false;
	private boolean pBust = false;
	private Player player = new Player("def", pHand, 5000);
	private Dealer dealer = new Dealer("tim", dHand, 5000);

	 public void run() {
		deck = new Deck();
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

	 private void deal(Hand h, Deck d) {
		Card deal = d.dealHand();
		h.addCardToHand(deal);

	}

	 private void startGame() {
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
	 private void gameLoop() {
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

	 private void playerTurn() {
		dealPlayer();

	}

	 private void dealerTurn() {
		while (dHand.handValue() < 17) {
			System.out.println();
			System.out.println(dealer.getName() + " (Dealer) will hit");
			dealDealer();
			if (pHitOrStand.equals("H")) { 
				gameLoop();
			}

		} // after loop finishes this prints causing duplication
		System.out.println();
		System.out.println(player.getName() + " (Dealer)");
		System.out.println("Dealer Total: " + dHand.handValue());
		System.out.println("Dealer is staying \n");
		dHitOrStand = "S";
	}

	 private boolean dealPlayer() {
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

	 private boolean dealDealer() {
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

	 private void initialDeal() {
		deck.addCardsToDeck();
		deal(pHand, deck);
		deal(dHand, deck);
		deal(pHand, deck);
		deal(dHand, deck);

	}

	 private void introduction() {

		System.out.println("Welcome to BlackJack.");
		System.out.print("What is your name? >> ");
		String playerName = kb.next();
		player.setName(playerName);
		System.out.println();
		System.out.print(playerName + ", what is your opponents name? >> ");
		String dealerName = kb.next();
		dealer.setName(dealerName);
		System.out.println();
		System.out.println(dealerName + " is dealing.");

	}

	 private void judgement() {
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


	 private void restart() {
		System.out.print("\nWould you like to play again (Y/N)? >> ");
		String restart = kb.next();
		if (restart.equals("Y")) {
			run();
		} else {
			System.exit(1);
		}
	}
}


