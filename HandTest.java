/**
 * Tester class for the hand object used in CIS 152's final project
 * It simply creates a hand object, adds test cards to it and displays its contents
 *
 * @author James Urban
 * @since  Fall 2017
 */
public class HandTest {
	public static void main (String args[]) {
		Hand hand = new Hand();
		hand.add(new Card(1,"Test 1"));
		hand.print();
		System.out.println(" ---- ");
		hand.add(new Card(2,"Test 2"));
		hand.add(new Card(3,"Test 3"));
		hand.add(new Card(4,"Test 4"));
		hand.print();
	}
}