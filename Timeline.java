/**
 * The object used to test the Timeline game
 * Used in CIS 152's final project
 *
 * @author James Urban
 * @since  Fall 2017
 */
public class Timeline {
		Deck deck;
		Hand hand;
		Tableau tableau; // the timeline

        /**
         * Default constructor
         */
		public Timeline() {
		}

        /**
         * Instantiates an instance of the Timeline, initializes it
         */
		public static void main (String args[]) {
			Timeline timeline = new Timeline();
			timeline.initialize();
			timeline.initiateTest();
		}

        /**
         * Creates new Timeline objects (deck, hand, tableau) and put the first card off
         * the deck into the tableau to set up the starting point of the game
         */
		private void initialize() {
			deck = new Deck();
			hand = new Hand();
			tableau = new Tableau();
			tableau.add(deck.drawCard());
		}

		/**
		 * Runs the test scenario that uses a fixed deck and predetermined playing of cards
		 * in order to test the deck, hand, and tableau objects
		 */
		private void initiateTest() {
			System.out.println("Timeline is chronologically valid: " + tableau.isChronologicallyValid());
			hand.add(deck.drawCard()); // Should be Premier of Star Trek on TV
			hand.add(deck.drawCard()); // Should be Starkbucks Founded
			hand.add(deck.drawCard()); // Should be Star Wars Released
			hand.add(deck.drawCard()); // Should be NASCAR Founded
			hand.add(deck.drawCard()); // Should be M&M's First Sold

			// Display the contents of the deck.  It should be Twilight Zone through Disneyland only
			System.out.println("\nRemaining Deck:");
			deck.displayDeck();

			// Display hand. Should be Star Trek, Starbucks, Star Wars, NASCAR, and M&M's
			System.out.println("\nCurrent Hand:");
			hand.print();

			// Play the Permier to Star Trek correctly before Microsoft Founded
			tableau.add(hand.remove("Premier of Star Trek on TV"), 0);
			tableau.isChronologicallyValid();

			// Display hand. Should be Starbucks, Star Wars, NASCAR, and M&M's
			System.out.println("\nCurrent Hand:");
			hand.print();

			// Play the Star Wars card correctly after Microsoft Founded
			tableau.add(hand.remove("Star Wars Released"),2);
			tableau.isChronologicallyValid();

			// Display hand. Should be Starbucks, NASCAR, and M&M's
			System.out.println("\nCurrent Hand:");
			hand.print();

			// Play the M&M's card incorrectly after Star Wars
			tableau.add(hand.remove("M&M's First Sold"), 3);
			tableau.print();
			tableau.isChronologicallyValid();
			tableau.print();

			// Display hand. Should be Starbucks, NASCAR, and <whatever card dealt for messing up M&M>
			System.out.println("\nCurrent Hand:");
			hand.print();
		}
}