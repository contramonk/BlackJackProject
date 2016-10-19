package game;

import java.util.Scanner;

public class Player extends Human {
	Scanner kb = new Scanner(System.in);

	public Player(String n) {
		super(n);
	}

	public void playerChoice() {
		System.out.print("\n1) Hit\n2) Stand >> ");
		setHitOrStand(kb.nextInt());
		System.out.println();
	}

}
