package game;

public class Game {
	public static void main(String[] args) {
		run();
		
	}
	public static void run() {
		Deck deck = new Deck(0);
		deck.addCardsToDeck();
		Hand h1 = new Hand();
		Player p1 = new Player("john", h1, 5000);
		
		System.out.println(deck);
		
	}
}
