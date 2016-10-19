package game;

import java.util.ArrayList;
import java.util.List;

public class Human {
	
	private String name;
	public Hand hand;
	private int hitOrStand = 5;
	private boolean bust = false;
	WinCondition win = new WinCondition();

	// Constructor
	public Human(String n) {
		hand = new Hand();
		setName(n);
	}

	// Get
	public String getName() {
		return name;
	}

	public Hand getHand() {
		return hand;
	}
	public int getHitOrStand() {
		return hitOrStand;
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

	public void setBust(boolean b) {
		this.bust = b;
	}
	public void setHitOrStand(int h) {
		this.hitOrStand = h;
	}
	
	

}
