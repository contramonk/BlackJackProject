package game;

import java.util.ArrayList;
import java.util.List;

public class Human {

	private String name;
	public Hand hand;
	private int hitOrStand = 5;
	private boolean bust = false;
	WinCondition win = new WinCondition();

	public Human(String n) {
		hand = new Hand();
		setName(n);
	}

	public boolean turn(BlackJack bj, Deck deck) {
		deck.deal(this);
		if (getHand().handValue() > 21) {
			setBust(true);
			hand.print(this);
			win.checkWinCondition(bj);
			return getBust();
		} else if (getHand().handValue() == 21) {
			hand.print(this);
			win.checkWinCondition(bj);
			return getBust();
		} else {
			hand.print(this);
			return getBust();
		}

	}

	public String getName() {
		return name;
	}

	public Hand getHand() {
		return hand;
	}

	public int getHitOrStand() {
		return hitOrStand;
	}

	public boolean getBust() {
		return bust;
	}

	public void setName(String n) {
		this.name = n;
	}

	public void setHand(Hand h) {
		this.hand = h;
	}

	public void setBust(boolean b) {
		this.bust = b;
	}

	public void setHitOrStand(int h) {
		this.hitOrStand = h;
	}

}
