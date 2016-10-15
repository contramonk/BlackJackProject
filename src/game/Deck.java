package game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Deck extends ArrayList<Card> implements Comparator<String> {
	int numDelt;

	// Constructor
	public Deck(int nd) {
		setNumDelt(nd);
	}

	// Get
	public int getNumDelt() {
		return numDelt;
	}

	// Set
	public void setNumDelt(int nd) {
		this.numDelt = nd;
	}

	public int compare(String o1, String o2) {
		return 0;
	}
	
	// Create Deck
	public void addCardsToDeck() {
		for (Suit s : Suit.values()) {
			for (Rank r : Rank.values()) {
				Card card = new Card(s, r);
				this.add(card);
			}
		}
		shuffle();
	}
	// Shuffle
	public void shuffle() {
		Collections.shuffle(this);
	}
	public Card dealHand() {
		Card topCard = this.get(0);
		this.remove(0);
		return topCard;
	}

}
