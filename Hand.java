/**
 * Hand utilizes a linked list for storage because the user may want to rearrange the cards
 * in her hand in what she thinks is the correct chronological order (or for some other reason)
 * Used in CIS 152's final project
 *
 * @author James Urban
 * @since  Fall 2017
 */
public class Hand {

   private LinkedList hand;   // The cards in the hand.

   /**
    * Creates a new empty hand
    */
   public Hand() {
      hand = new LinkedList();
   }

   /**
    * Adds a card to the hand. It is added at the end of the current hand.
    * @param crd The card to be added.
    */
   public void add(Card crd) {
	  if (crd != null) {
	      hand.add(crd);
	  }
   }

   /**
    * Removes a card from the hand, if present.
    * @param c the card to be removed.  If the card is not in the hand, then nothing happens.
    */
   public Card remove(String s) {
	   Object hold = hand.find(s);
	   if (hold != null) {
		   hand.remove(hold);
	   	   System.out.println("Found and removed " + ((Card)hold).text);
	   	   return (Card)hold;
	   } else {
		   System.out.println("Unable to find " + s);
		   return null;
	   }
   }

   /**
    * Returns the number of cards in the hand.
    */
   public int getCardCount() {
      return 99; //hand.size();
   }

	/**
	 * Prints out the cards in the shuffled deck in order from bottom to top
	 */
	public void print() {
		hand.display();
	}

}