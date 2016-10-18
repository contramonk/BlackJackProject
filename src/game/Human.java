package game;

import java.util.ArrayList;
import java.util.List;

public class Human {
	
	private String name;
	private double wallet;
	private Hand hand;
	private boolean bust = false;

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
	public boolean getBust() {
		return bust;
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
	public void setBust(boolean b) {
		this.bust = b;
	}
	
	

}
