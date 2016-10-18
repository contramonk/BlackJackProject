package game;

public class Player extends Human {
	WinCondition win = new WinCondition();

	public Player(String n, double w) {
		super(n, w);
	}
	
	public boolean playerTurn(BlackJack bj, Deck deck) {
		deck.deal(this);
		System.out.println();
		System.out.println(getName() + " (Player)");
		System.out.println("----------------------------------------");
		getHand().printHand();
		System.out.println("----------------------------------------");
		System.out.println("Hand Total: " + this.getHand().handValue());
		System.out.println("----------------------------------------");
		if (getHand().handValue() > 21) {
			System.out.println("~~~Player Busted~~~");
			setBust(true);
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

