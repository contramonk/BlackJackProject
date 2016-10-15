package game;

public class Game {
	public static void main(String[] args) {
		run();
		
	}
	public static void run() {
		Deck deck = new Deck(0);
		deck.addCardsToDeck();
		
		System.out.println(deck);
		
	}
}
