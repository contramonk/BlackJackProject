package game;

import java.util.ArrayList;

public class Hand extends ArrayList<Card> {
	private int handTotal = 0;
	
	public Hand() {
		
	}
	// Get
	public int getHandTotal() {
		return handTotal;
	}
	// Set
	public void setHandTotal(int ht) {
		this.handTotal = ht;
	}
	public void addCardToHand(Card c) {

		this.add(c);

	}
	
	public int handValue() {
		for (int i = 0; i < this.size()/2; i+=2) {
			try {
			handTotal += this.get(i).getValue() + this.get(i+1).getValue();
			}
			catch(IndexOutOfBoundsException iob) {
				handTotal += this.get(i).getValue();
			}
		}
		return handTotal;
		
	}

}
