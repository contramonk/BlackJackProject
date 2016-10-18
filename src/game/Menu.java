package game;

import java.util.Scanner;

public class Menu {
	private Scanner kb = new Scanner(System.in);

	public void menu(Player player, Dealer dealer) {
		System.out.println("Welcome to BlackJack.");
		System.out.print("What is your name? >> ");
		String playerName = kb.next();
		player.setName(playerName);
		System.out.println();
		System.out.print(playerName + ", what is your opponents name? >> ");
		String dealerName = kb.next();
		dealer.setName(dealerName);
		System.out.println();
	}

}
