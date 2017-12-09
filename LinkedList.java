/**
 * Implemention of a linked list for use in CIS 152's final project
 * This is the primary workhorse of the Timeline game in that it contains
 * the searching, removing, and adding of cards to the hand and tableau
 * as well as the validation logic for ensuring the chronological integrity
 * of the timeline is preserved
 *
 * @author James Urban
 * @since  Fall 2017
 */
public class LinkedList {

	Link first; 		// The LinkedList needs to know from where to start traversing the list
	int length = 0;		// Convenient for list-type objects to know their size

	/**
	 * Creates an empty linked list object. Useful for declaring a linked list when the
	 * first object to be stored in the linked list isn't known.
	 */
	public LinkedList() {
		first = null;
		length = 0;
	}

	/**
	 * Creates a linked list object, starting with the specified object
	 *
	 * @param The first object to be placed into the LinkedList
	 */
	public LinkedList(Object o) {
		first = new Link(o);
		length = 1;
	}

	/**
	 * Provides access to the number of objects in the list
	 * @returns An integer value of the number of objects in the list
	 */
	public int size() {
		return length;
	}

	/**
	 * Adds a new Card object to the list
	 * and increments the length of the list accordingly
	 */
	public void add(Object o) {
		Link newLink = new Link(o);
		if (first == null) {
			first = newLink;
		} else {
				Link currentLink = first;
				while (currentLink.getNext() != null) { // Iterate to end
					currentLink = currentLink.getNext();
				}
				currentLink.setNext(newLink);
		}
		length++;
		System.out.println("Added " + newLink.getContents().toString());
	}

	/**
	 * Adds a new Can object to the list in the specified position
	 * and increments the length of the list accordingly
	 */
	public void add(Object o, int pos) {
		Link newLink = new Link(o);
		int location = 0;
		if (first == null) {
			// If the list is empty, the position is irrelevant
			first = newLink;
		} else if (pos == 0) {
			newLink.setNext(first);
			first = newLink;
		} else {
				Link currentLink = first;
				while (currentLink.getNext() != null && location != pos) {
					currentLink = currentLink.getNext();
				}
				currentLink.setNext(newLink);
		}
		length++;
		System.out.println("Added " + newLink.getContents().toString());
	}

	/**
	 * Removes an object from the list at the specified position
	 * and decrements the length of the list accordingly
	 * @returns The card at the specified position, else null
	 */
	public Card remove(int pos) {
		Card hold = null;
		int location = 0;
		if (first == null) {
			// If the list is empty, the position is irrelevant
			return null;
		} else if (pos == 0) {
			if (first.getNext()!= null) {
				hold = (Card)first.getContents();
				first = first.getNext();
			}
		} else {
				Link currentLink = first;
				while (currentLink.getNext() != null && location != pos) {
					currentLink = currentLink.getNext();
				}
				hold = (Card)currentLink.getContents();
				remove(currentLink.getContents());
		}
		return hold;
	}

	/**
	 * Removes the specified Card object from the list (if the specified object is found)
	 * and decrements the length of the list accordingly
	 *
	 * @return False if the object isn't found, else true
	 */
	public boolean remove(Object o) {
		Link previousLink = null;
		Link currentLink = null;
		if (first == null) {
			return false;
		} else {
				currentLink = first;
				while (currentLink == first || currentLink.getNext() != null) {
					if ((Card)currentLink.getContents() == (Card)o) {
						if (currentLink == first) {
							if (currentLink.getNext() != null) {
								first = currentLink.getNext();
							} else {
								first = null;
							}
							System.out.println("Removed " + currentLink.getContents().toString());
						} else {
							if (currentLink.getNext() != null && previousLink != null) {
								previousLink.setNext(currentLink.getNext());
								System.out.println("Removed " + currentLink.getContents().toString());
								length--;
								return true;
							}
						}
					}
					previousLink = currentLink;
					currentLink = currentLink.getNext();
				}
		}
		// Check if last link is the desired link
		if ((Card)currentLink.getContents() == (Card)o && previousLink != null) {
			previousLink.setNext(null);
			System.out.println("Removed " + currentLink.getContents().toString() + " from the end of the list");
			length--;
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Returns the specified object
	 *
	 * @param the object to look for in the list
	 * @return The specified object if found, otherwise return null
	 */
	public Object get(Object obj) {
		Link currentLink = first;
		while (currentLink != null && currentLink.getContents() != obj) {
			currentLink = currentLink.getNext();
		}
		return currentLink.getContents();
	}

	/**
	 * Iterates through the list until a card having the specified string text is encountered
	 * @return The card with the specified text or null if no card with the specified text is found
	 */
	public Object find(String s) {
		Link currentLink = null;
		if (first != null) {
			currentLink = first;
			while(currentLink.getNext() != null) {
				if (((Card)currentLink.getContents()).text.equals(s)) {
					return currentLink.getContents();
				}
				currentLink = currentLink.getNext();
			}
		}
		// Check if last link is the desired link
		if (currentLink != null && ((Card)currentLink.getContents()).text.equals(s)) {
			return currentLink.getContents();
		} else {
			return null;
		}
	}

	/**
	 * Prints out the contents of the list
	 */
	public void display() {
		if (first != null) {
			Link currentLink = first;
			while(currentLink.getNext() != null) {
				currentLink.print();
				currentLink = currentLink.getNext();
			}
			currentLink.print();
		}
	}

	/**
	 * Checks to see if the list is in correct chronological order
	 *
	 * @return The card that is in the incorrect chronological order (if one is encountered), otherwise null
	 */
	public Card validateChronology() {
		//System.out.println("Validating cards in list of length: " + length);
		int cardPos = 0;
		Link currentLink = null;
		if (length > 1) {
			// if zero or one items are in the list, it must be valid chronologically
			currentLink = first;
			while(currentLink.getNext() != null) {
				cardPos++;
				if (((Card)currentLink.getContents()).year > ((Card)currentLink.getNext().getContents()).year) {
					return (Card)currentLink.getNext().getContents();
				}
				currentLink = currentLink.getNext();
			}
		}
		return null;
	}

	/**
	 * Adds a Card object to the list chronologically by year
	 */
	public void addInProperPostion(Card c) {
		Link newLink = new Link(c);
		if (first == null) {
			first = newLink;
		} else {
			if (c.year < ((Card)(first.getContents())).year) {
				newLink.setPrevious(null);
				newLink.setNext(first);
				first = newLink;
			} else {
				Link currentLink = first;
				while (currentLink.getNext() != null) {
					if (((Card)(currentLink.getNext().getContents())).year > c.year) {
						newLink.setPrevious(currentLink);
						newLink.setNext(currentLink.getNext());
						currentLink.setNext(newLink);
						break;
					}
					currentLink = currentLink.getNext();
				}
				currentLink.setNext(newLink);
			}
		}
	}

	/**
	 * Removes the specified incorrectly ordered card from the list and inserts it in the correct order
	 *
	 * @param The incorrectly ordered card
	 */
	public void correctChronology(Card c) {
		remove(c);
		addInProperPostion(c);
		System.out.println("The timeline has been restored");
	}

}





