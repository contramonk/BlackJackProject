package game;

public class WinCondition {

	public void checkWinCondition(BlackJack bj) {
		System.out.println();

		if (bj.player.getBust()) {
			System.out.println("****** " + bj.dealer.getName() + " is the winner. ******");
			bj.restart();
		} else if (bj.dealer.getBust()) {
			System.out.println("****** " + bj.player.getName() + " is the winner. ******");
			bj.restart();
		} else if (bj.dealer.getHand().handValue() == 21) {
			System.out.println("****** " + bj.dealer.getName() + " has BLACKJACK. ******");
			bj.restart();
		} else if (bj.player.getHand().handValue() == 21) {
			System.out.println("****** " + bj.player.getName() + " has BLACKJACK. ******");
			bj.restart();
		} else if (bj.dealer.getHand().handValue() > bj.player.getHand().handValue() && bj.pHitOrStand.equals("S")
				&& bj.dHitOrStand.equals("S")) {
			System.out.println("****** " + bj.dealer.getName() + " is the winner. ******");
			bj.restart();
		} else if (bj.player.getHand().handValue() > bj.dealer.getHand().handValue() && bj.pHitOrStand.equals("S")
				&& bj.dHitOrStand.equals("S")) {
			System.out.println(" ****** " + bj.player.getName() + " is the winner. ******");
			bj.restart();
		} else if (bj.player.getHand().handValue() == bj.dealer.getHand().handValue() && bj.pHitOrStand.equals("S")
				&& bj.dHitOrStand.equals("S")) {
			System.out.println("****** " + bj.dealer.getName() + " is the winner. ******");
			bj.restart();
		}

	}
}
