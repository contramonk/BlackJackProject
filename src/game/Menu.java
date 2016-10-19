package game;

import java.util.Scanner;

public class Menu {
	String playerName;
	String dealerName;
	private Scanner kb = new Scanner(System.in);

	public void menu(Player player, Dealer dealer) {
		System.out.println("Welcome to BlackJack. \n");
		System.out.print("What is your name? >> ");
		playerName = kb.next();
		System.out.print("\n" + "What is your opponents name? >> ");
		dealerName = kb.next();
		System.out.println();
		setNames(player, dealer);
	}

	public void setNames(Player p, Dealer d) {
		p.setName(playerName);
		d.setName(dealerName);

	}

}
