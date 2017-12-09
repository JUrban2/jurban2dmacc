/**
 *
 * Implemention of a simple linked list (forward navigation only)
 */
public class LinkedListStack {

	Link first; 		// The LinkedList needs to know from where to start traversing the list
	int length = 0;		// Convenient for list-type objects to know their size

	/**
	 * Creates an empty linked list object. Useful for declaring a linked list when the
	 * first object to be stored in the linked list isn't known.
	 */
	public LinkedListStack() {
		first = null;
		length = 0;
	}

	/**
	 * Creates a linked list object, starting with the specified object
	 *
	 * @param The first object to be placed into the LinkedList
	 */
	public LinkedListStack(Object o) {
		first = new Link(o);
		length = 1;
	}

	/**
	 * Stacks have items added to the rear and removed from the rear (last in, first out)
	 */
	public void add(Card o) {
		Link newLink = new Link(o);
		if (first == null) {
			first = newLink;
		} else {
				Link currentLink = first;
				newLink.setNext(first);
				first = newLink;
		}
		System.out.println("Added " + newLink.getContents().toString());
	}

	/**
	 * Removes the specified card
	 *
	 * @param The card to be removed
	 */
	public Object remove(Card crd) {
		Object hold = null;
		Link prev = null;
		if (first != null) {
				Link currentLink = first;
				while (currentLink.getNext() != null) { // Checks to see if there's a next Card
					prev = currentLink;
					currentLink = currentLink.getNext();
				}
				prev.setNext(null);
				hold = currentLink.getContents();
				System.out.println("Removed " + hold.toString());
		}
		return hold;
	}

	public Object pop() {
		Link hold = null;
		if (first != null) {
			hold = first;
			if (hold.getNext() != null) {
				first = hold.getNext();
			}
		}
		return hold.getContents();
	}

	/**
	 * Prints out the contents of the list from from to back
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
	 *
	 */
	public int size() {
		return length;
	}

}





