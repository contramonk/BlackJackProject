package game;

import java.util.ArrayList;

public class Hand extends ArrayList<Card> {
	private int handTotal = 0;
	int counter = 0;

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
		counter++;
		handTotal = 0;
		
		for (int i = 0; i < this.size(); i++) {
			handTotal += this.get(i).getValue();
		}

		if (handTotal > 21 && counter < this.size()) {
			for (int i = 0; i < this.size(); i++) {
				if (this.get(i).getValue() == 11) {
					this.get(i).setValue(1);
					break;
				}
			}
			handValue();
		}
		counter = 0;
		return handTotal;

	}

	public void printHand() {
		for (Card card : this) {
			System.out.println(card);
		}
	}

}
