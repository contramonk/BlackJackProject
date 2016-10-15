package game;

public class Human {
	private String name;
	private Hand hand;
	private double wallet;
	
	// Constructor
	public Human(String n, Hand h, double w) {
		setName(n);
		setHand(h);
		setWallet(w);
	}
	// Get
	public String getName() {
		return name;
	}
	public Hand getHand() {
		return hand;
	}
	public double getWallet() {
		return wallet;
	}
	// Set
	public void setName(String n) {
		this.name = n;
	}
	public void setHand(Hand h) {
		this.hand = h;
	}
	public void setWallet(double w) {
		this.wallet = w;
	}
	
}
