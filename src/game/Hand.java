package game;

import java.util.ArrayList;

public class Hand extends ArrayList<Card> {

	public void addCardToHand() {
		
		Card c1 = new Card(Suit.CLUBS, Rank.JACK);
		Card c2 = new Card(Suit.HEARTS, Rank.EIGHT);
		
		this.add(c1);
		
	}

	

}
