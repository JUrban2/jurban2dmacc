import java.util.Random;

/**
 * Deck object used in CIS 152's final project
 *
 *
 * @author James Urban
 * @since  Fall 2017
 */
public class Deck {
	LinkedList unshuffledDeck;    // Premilnary list of cards used to create the deck
	LinkedListStack shuffledDeck; // The randomly sorted list from unshuffledDeck placed into a stack like a deck of cards

	/**
	 * Deliberately initializing with an unsorted list to test deck and hand unit test
	 */
	public Deck() {
		shuffledDeck = new LinkedListStack();
		unshuffledDeck = new LinkedList();
		shuffledDeck.add(new Card(1959, "Premier of Twilght Zone on TV"));
		shuffledDeck.add(new Card(1940, "For Whom the Bell Tolls Published"));
		shuffledDeck.add(new Card(1967, "First Superbowl Halftime Show"));
		shuffledDeck.add(new Card(1976, "Apple Founded"));
		shuffledDeck.add(new Card(1958, "First US Satellite Launched"));
		shuffledDeck.add(new Card(1947, "Miracle on 34th Street Released"));
		shuffledDeck.add(new Card(1942, "Pentagon Opens"));
		shuffledDeck.add(new Card(1955, "Disneyland Opens"));
		shuffledDeck.add(new Card(1941, "M&M's First Sold"));
		shuffledDeck.add(new Card(1948, "NASCAR Founded"));
		shuffledDeck.add(new Card(1977, "Star Wars Released"));
		shuffledDeck.add(new Card(1971, "Starkbucks Founded"));
		shuffledDeck.add(new Card(1966, "Premier of Star Trek on TV"));
		shuffledDeck.add(new Card(1975, "Microsoft Founded"));
	}

	/**
	 * Prints out the cards in the shuffled deck in order from bottom to top
	 */
	public void displayDeck() {
    	shuffledDeck.display();
	}

	/**
	 * Custom algorithm for randomising the order of the cards in the unshuffled deck
	 * and placing the result into the shuffled deck.
	 */
 	public void shuffle() {
    	System.out.println("Shuffling deck...");
    	Random rnd = new Random();
    	int selectedCard = 0;
    	while (unshuffledDeck.size() > 0) {
			selectedCard = rnd.nextInt(unshuffledDeck.size());            // Select a random card from those remaining in the unshuffled deck
			shuffledDeck.add(unshuffledDeck.remove(selectedCard));
			  // Remove the selected card from the unshuffled list to the shuffled stack
    	}
	}

	/**
	 * Gets the next card on the top of the deck
	 * @returns The card at the top of the shuffled deck
	 */
	public Card drawCard() {
		return (Card)shuffledDeck.pop();
	}

}