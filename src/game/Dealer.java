package game;

public class Dealer extends Human {

	public Dealer(String n) {
		super(n);
	}

	public void dealerTurn(BlackJack bj, Deck deck) {
		while (getHand().handValue() < 17) {
			System.out.println("\n" + getName() + " (" + getClass().getSimpleName() + ") will hit \n");
			turn(bj, deck);
			if (getHitOrStand() == 1) {
				bj.gameLoop();
			}

		}
		System.out.println("\n " + getName() + " (" + getClass().getSimpleName() + ") is staying \n");
		setHitOrStand(2);
	}

}
