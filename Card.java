/**
 * Represents a card used in my CIS 152's final project card game named Timeline
 *
 * @author James Urban
 * @since  Fall 2017
 */
public class Card {
	int year;
	String text;

	/**
	 * Constructor for initializing a new Card object with its year and text
	 *
	 * @param yr - the year the event occurred
	 * @param txt - the textual description of the event
	 */
	public Card (int yr, String txt) {
		year = yr;
		text = txt;
	}

	/**
	 * Nicely formats the year and text data for human comprehension
	 *
	 * @return The formatted year/text string
	 */
	public String toString() {
		return year + " - " + text;
	}
}