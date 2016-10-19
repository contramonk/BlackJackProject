package game;

public class Dealer extends Human {
	
	public Dealer(String n) {
		super(n);
	}
	
	public void dealerTurn(BlackJack bj, Deck deck) {
		while (getHand().handValue() < 17) {
			System.out.println("\n" + getName() + " (Dealer) will hit \n");
			dealDealer(bj, deck);
			if (this.getHitOrStand() == 1) {
				bj.gameLoop();
			}

		}
		System.out.println("\n " + getName() + "Dealer is staying \n");
		this.setHitOrStand(2);
	}
	
	private boolean dealDealer(BlackJack bj, Deck deck) {
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
			hand.print(this);
			return getBust();
		}

	}
}
