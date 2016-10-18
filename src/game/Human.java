package game;

import java.util.ArrayList;
import java.util.List;

public class Human {
	
	private String name;
	private double wallet;
	private Hand hand;

	// Constructor
	public Human(String n, double w) {
		hand = new Hand();
		setName(n);
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
