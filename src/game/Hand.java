package game;

import java.util.ArrayList;

public class Hand extends ArrayList<Card> {
	private int handTotal = 0;
	int counter = 0;

	public void addCardToHand(Card c) {

		this.add(c);

	}

	public int handValue() {
		counter++;
		handTotal = 0;

		for (int i = 0; i < size(); i++) {
			handTotal += get(i).getValue();
		}

		if (handTotal > 21 && counter < size()) {
			for (int i = 0; i < size(); i++) {
				if (get(i).getValue() == 11) {
					get(i).setValue(1);
					break;
				}
			}
			handValue();
		}
		counter = 0;
		return handTotal;

	}

	public void print(Human hum) {
		System.out.println();
		System.out.println(hum.getName() + " (" + hum.getClass().getSimpleName() + ")");
		System.out.println("----------------------------------------");
		listHand();
		System.out.println("----------------------------------------");
		System.out.println("Hand Total: " + handValue());
		System.out.println("----------------------------------------");
		if (hum.getBust() == true) {
			System.out.println(hum.getClass().getSimpleName() + " BUSTED");
		}
	}

	public void listHand() {

		for (Card card : this) {
			System.out.println(card);
		}
	}

	public int getHandTotal() {
		return handTotal;
	}

	public void setHandTotal(int ht) {
		this.handTotal = ht;
	}

}
