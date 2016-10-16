package game;

public class Card {
	private Suit suit;
	private int value;
	private Rank rank;
	
	public Card(Suit s, Rank r) {
		setSuit(s);
		setRank(r);
		
		switch(r) {
		case ACE:
			setValue(11);
			break;
		case KING:
		case QUEEN:
		case JACK:
		case TEN:
			setValue(10);
			break;
		case NINE:
			setValue(9);
			break;
		case EIGHT:
			setValue(8);
			break;
		case SEVEN:
			setValue(7);
			break;
		case SIX:
			setValue(6);
			break;
		case FIVE:
			setValue(5);
			break;
		case FOUR:
			setValue(4);
			break;
		case THREE:
			setValue(3);
			break;
		case TWO:
			setValue(2);
			break;
		case ONE:
			setValue(1);
			break;
		}
		
	}
	// Get
	public Suit getSuit() {
		return suit;
	}
	public int getValue() {
		return value;
	}
	public Rank getRank() {
		return rank;
	}
	// Set
	public void setSuit(Suit s) {
		this.suit = s;
	}
	public void setValue(int v) {
		this.value = v;
	}
	public void setRank(Rank r) {
		this.rank = r;
	}
	// Print Object
	public String toString() {
		return "suit: " + suit + " rank: " + rank + " value: " + value;
	}
}
