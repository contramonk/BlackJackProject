package game;

import java.util.Scanner;

 public class BlackJack {
	
	private Deck deck = new Deck();
	private Scanner kb = new Scanner(System.in);
	private String dHitOrStand = "C";
	private String pHitOrStand = "C";
	private boolean dBust = false;
	private boolean pBust = false;
	private Player player = new Player("def", 5000.0);
	private Dealer dealer = new Dealer("tim", 5000.0);

	 public void run() {
		deck = new Deck();
		pBust = false;
		dBust = false;
		player = new Player("def", 5000);
		dealer = new Dealer("def", 5000);
		dHitOrStand = "C";
		pHitOrStand = "C";

		Menu menu = new Menu();
		menu.menu(player, dealer);
		
		initialDeal();
		startGame();

		
	}

	 private void startGame() {
		System.out.println();
		System.out.println(player.getName() + " (Player)");
		System.out.println("----------------------------------------");
		player.getHand().printHand();
		System.out.println("----------------------------------------");
		System.out.println("Total: " + player.getHand().handValue());
		System.out.println("----------------------------------------");
		System.out.println();
		System.out.println(dealer.getName() + " (Dealer)");
		System.out.println("----------------------------------------");
		dealer.getHand().printHand();
		System.out.println("----------------------------------------");
		System.out.println("Total: " + player.getHand().handValue());
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
		while (dealer.getHand().handValue() < 17) {
			System.out.println();
			System.out.println(dealer.getName() + " (Dealer) will hit");
			dealDealer();
			if (pHitOrStand.equals("H")) { 
				gameLoop();
			}

		} // after loop finishes this prints causing duplication
		System.out.println();
		System.out.println(player.getName() + " (Dealer)");
		System.out.println("Dealer Total: " + dealer.getHand().handValue());
		System.out.println("Dealer is staying \n");
		dHitOrStand = "S";
	}

	 private boolean dealPlayer() {
		deck.deal(player);
		System.out.println();
		System.out.println(player.getName() + " (Player)");
		System.out.println("----------------------------------------");
		player.getHand().printHand();
		System.out.println("----------------------------------------");
		System.out.println("Hand Total: " + player.getHand().handValue());
		System.out.println("----------------------------------------");
		if (player.getHand().handValue() > 21) {
			System.out.println("~~~Player Busted~~~");
			pBust = true;
			judgement();
			return pBust;

		} else if (player.getHand().handValue() == 21) {
			judgement();
			return pBust;
		} else {
			return pBust;
		}
	}

	 private boolean dealDealer() {
		deck.deal(dealer);
		if (dealer.getHand().handValue() > 21) {
			System.out.println();
			System.out.println(dealer.getName() + "(Dealer)");
			System.out.println("----------------------------------------");
			dealer.getHand().printHand();
			System.out.println("----------------------------------------");
			System.out.println("Dealer Total: " + dealer.getHand().handValue());
			System.out.println("----------------------------------------");
			System.out.println("~~~Dealer busted~~~");
			dBust = true;
			judgement();
			return dBust;
		} else if (dealer.getHand().handValue() == 21) {
			judgement();
			return dBust;
		} else {
			System.out.println();
			System.out.println(dealer.getName() + "(Dealer)");
			System.out.println("----------------------------------------");
			dealer.getHand().printHand();
			System.out.println("----------------------------------------");
			System.out.println("Dealer Total: " + dealer.getHand().handValue());
			System.out.println("----------------------------------------");
			return dBust;
		}

	}

	 private void initialDeal() {
		deck.addCardsToDeck();
		deck.deal(player);
		deck.deal(dealer);
		deck.deal(player);
		deck.deal(dealer);

	}

	 private void judgement() {
		System.out.println();

		if (pBust) {
			System.out.println("****** " + dealer.getName() + " is the winner. ******");
			restart();
		} else if (dBust) {
			System.out.println("****** " + player.getName() + " is the winner. ******");
			restart();
		} else if (dealer.getHand().handValue() == 21) {
			System.out.println("****** " + dealer.getName() + " has BLACKJACK. ******");
			restart();
		} else if (player.getHand().handValue() == 21) {
			System.out.println("****** " + player.getName() + " has BLACKJACK. ******");
			restart();
		} else if (dealer.getHand().handValue() > player.getHand().handValue() && pHitOrStand.equals("S") && dHitOrStand.equals("S")) {
			System.out.println("****** " + dealer.getName() + " is the winner. ******");
			restart();
		} else if (player.getHand().handValue() > dealer.getHand().handValue() && pHitOrStand.equals("S") && dHitOrStand.equals("S")) {
			System.out.println(" ****** " + player.getName() + " is the winner. ******");
			restart();
		} else if (player.getHand().handValue() == dealer.getHand().handValue() && pHitOrStand.equals("S") && dHitOrStand.equals("S")) {
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


