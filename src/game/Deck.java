package game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Deck extends ArrayList<Card> implements Comparator<String> {

	public void addCardsToDeck() {
		for (Suit s : Suit.values()) {
			for (Rank r : Rank.values()) {
				Card card = new Card(s, r);
				this.add(card);
			}
		}
		shuffle();
	}

	public void shuffle() {
		Collections.shuffle(this);
	}

	public Card pullCardFromDeck() {
		Card topCard = this.get(0);
		this.remove(0);
		return topCard;
	}

	public void deal(Human hum) {
		hum.getHand().addCardToHand(pullCardFromDeck());

	}

	public int compare(String o1, String o2) {
		return 0;
	}
}
