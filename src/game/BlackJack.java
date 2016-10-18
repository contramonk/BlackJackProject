package game;

import java.util.Scanner;

public class BlackJack {

	private Deck deck = new Deck();
	private WinCondition win = new WinCondition();
	private Scanner kb = new Scanner(System.in);
	public String dHitOrStand = "C";
	public String pHitOrStand = "C";
	public Player player = new Player("def", 5000.0);
	public Dealer dealer = new Dealer("tim", 5000.0);

	public void run() {
		deck = new Deck();
		player = new Player("def", 5000);
		dealer = new Dealer("def", 5000);
		dHitOrStand = "C";
		pHitOrStand = "C";

		Menu menu = new Menu();
		menu.menu(player, dealer);

		deck.initialDeal(this, deck);
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
		System.out.println("Total: " + dealer.getHand().handValue());
		System.out.println("----------------------------------------");
		win.checkWinCondition(this);

		dHitOrStand = "F";
		gameLoop();

		if (pHitOrStand.equals("S") && dHitOrStand.equals("S") || player.getBust() == false
				|| dealer.getBust() == false) {
			win.checkWinCondition(this);
		}

	}

	public void gameLoop() {
		while (!(pHitOrStand.equals("S") && dHitOrStand.equals("S")) || (player.getBust() && dealer.getBust())) {
			System.out.println();
			System.out.print("H) Hit\nS) Stand >> ");
			pHitOrStand = kb.next();
			System.out.println();
			switch (pHitOrStand) {
			case "H":
				player.playerTurn(this, deck);
				dealer.dealerTurn(this, deck);
				break;
			case "S":
				dealer.dealerTurn(this, deck);
				break;
			}
		}

	}

	public void restart() {
		System.out.print("\nWould you like to play again (Y/N)? >> ");
		String restart = kb.next();
		if (restart.equals("Y")) {
			run();
		} else {
			System.exit(1);
		}
	}
}
