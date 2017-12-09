/**
 *
 */
public class Tableau {

	LinkedList tableau;

    /**
     *
     */
	public Tableau() {
		tableau = new LinkedList();
	}

    /**
     *
     */
	public void add(Object o) {
		tableau.add(o);
	}

    /**
     *
     */
	public void add(Object o, int pos) {
		tableau.add(o, pos);
	}

    /**
     *
     */
	public void print() {
		System.out.println("*** Cards in Tableau ***");
		tableau.display();
		System.out.println("************************");
	}

    /**
     *
     */
	public LinkedList getList() {
		return tableau;
	}

    /**
     *
     */
	public boolean isChronologicallyValid() {
		Card incorrectCard = tableau.validateChronology();
		if (incorrectCard != null) {
			System.out.println(incorrectCard + " was not placed proper chronological order");
			tableau.correctChronology(incorrectCard);
			return false;
		}
		return true;
	}
}