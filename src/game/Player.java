package game;

import java.util.Scanner;

public class Player extends Human {
	Scanner kb = new Scanner(System.in);
	

	public Player(String n) {
		super(n);
	}
	
	public void playerChoice() {
		System.out.print("\n1) Hit\n2) Stand >> ");
		this.setHitOrStand(kb.nextInt());
		System.out.println();
	}
	
	public boolean playerTurn(BlackJack bj, Deck deck) {
		deck.deal(this);
		if (getHand().handValue() > 21) {
			setBust(true);
			hand.print(this);
			win.checkWinCondition(bj);
			return getBust();

		} else if (getHand().handValue() == 21) {
			win.checkWinCondition(bj);
			return getBust();
		} else {
			return getBust();
		}
	}
}

