package game;

public class Game {
	public static void main(String[] args) {
		run();
		
	}
	public static void run() {
		
		Deck deck = new Deck(0);
		deck.addCardsToDeck();
		Hand pHand = new Hand();
		Hand dHand = new Hand();
		Player player = new Player("john", pHand, 5000);
		Dealer dealer = new Dealer("Fred", dHand, 5000);
		
		deal(pHand, deck);
		deal(dHand, deck);
		deal(pHand, deck);
		
		
		
		
		System.out.println(pHand);
		
	}
	public static void deal(Hand h, Deck d) {
		Card deal = d.dealHand();
		h.addCardToHand(deal);
		
	}
}
