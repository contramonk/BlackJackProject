package game;

import java.util.Scanner;

public class BlackJack {

	private Deck deck = new Deck();
	private WinCondition win = new WinCondition();
	public Player player;
	public Dealer dealer;
	private Scanner kb = new Scanner(System.in);

	public void run() {
		deck = new Deck();
		player = new Player("def");
		dealer = new Dealer("def");

		Menu menu = new Menu();
		menu.menu(player, dealer);

		startGame();

	}

	private void startGame() {
		deck.initialDeal(this, deck);
		player.hand.print(player);
		dealer.hand.print(dealer);
		win.checkWinCondition(this);
		gameLoop();

		if (player.getHitOrStand() == 2 && dealer.getHitOrStand() == 2 || player.getBust() == false
				|| dealer.getBust() == false) {
			win.checkWinCondition(this);
		}

	}

	public void gameLoop() {
		
		while (!(player.getHitOrStand() == 2 && dealer.getHitOrStand() == 2)
				|| (player.getBust() && dealer.getBust())) {
			round();
		}

	}

	public void round() {
		player.playerChoice();
		switch (player.getHitOrStand()) {
		case 1:
			player.turn(this, deck);
			dealer.dealerTurn(this, deck);
			break;
		case 2:
			dealer.dealerTurn(this, deck);
			break;
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
