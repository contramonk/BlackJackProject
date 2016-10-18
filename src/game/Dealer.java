package game;

public class Dealer extends Human {
	WinCondition win = new WinCondition();
	public Dealer(String n, double w) {
		super(n, w);
	}
	
	public void dealerTurn(BlackJack bj, Deck deck) {
		while (getHand().handValue() < 17) {
			System.out.println();
			System.out.println(getName() + " (Dealer) will hit");
			dealDealer(bj, deck);
			if (bj.pHitOrStand.equals("H")) {
				bj.gameLoop();
			}

		} // after loop finishes this prints causing duplication
		System.out.println();
		System.out.println(getName() + " (Dealer)");
		System.out.println("Dealer Total: " + getHand().handValue());
		System.out.println("Dealer is staying \n");
		bj.dHitOrStand = "S";
	}
	
	private boolean dealDealer(BlackJack bj, Deck deck) {
		deck.deal(this);
		if (getHand().handValue() > 21) {
			System.out.println();
			System.out.println(getName() + "(Dealer)");
			System.out.println("----------------------------------------");
			getHand().printHand();
			System.out.println("----------------------------------------");
			System.out.println("Dealer Total: " + getHand().handValue());
			System.out.println("----------------------------------------");
			System.out.println("~~~Dealer busted~~~");
			setBust(true);
			win.checkWinCondition(bj);
			return getBust();
		} else if (getHand().handValue() == 21) {
			win.checkWinCondition(bj);
			return getBust();
		} else {
			System.out.println();
			System.out.println(getName() + "(Dealer)");
			System.out.println("----------------------------------------");
			getHand().printHand();
			System.out.println("----------------------------------------");
			System.out.println("Dealer Total: " + getHand().handValue());
			System.out.println("----------------------------------------");
			return getBust();
		}

	}
}
