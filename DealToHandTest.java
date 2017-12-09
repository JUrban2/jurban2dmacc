/**
 * Test class used in CIS 152's final project
 * to ensure cards are being drawn from the deck
 * and added to the hand
 *
 * @author James Urban
 * @since  Fall 2017
 */
public class DealToHandTest {
	public static void main (String args[]) {
		Deck deck = new Deck();
		Hand hand = new Hand();
		deck.displayDeck();

		for (int x = 0; x < 5; x++) {
			hand.add(deck.drawCard());
		}

		System.out.println("\n -- Hand -- ");
		hand.print();

		System.out.println("\n -- Deck -- ");
		deck.displayDeck();
	}
}