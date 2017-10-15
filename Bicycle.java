/**
 * CIS152 - Module 3 Abstract Class Assignment
 * A bicycle by definition has 2 tires so no provision is made for any number of tires other than 2
 * Similarly, a bicycle is assumed to have no flat tires when first starting, so no provision is
 * made for starting with any flats.
 */
public class Bicycle extends Cycle {

	/**
	 * Default constructor for Bicyle.
	 */
	public Bicycle() {
		numberOfTires = 2;
		numberOfFlats = 0;
	}

	/**
	 * Ride the bike. If the bike has no flat tires, it's possible to ride.
	 * If the bike has one or more flat tires, it will not be possible to ride it.
	 */
	public void ride() {
		if (numberOfFlats == 0) {
			System.out.println("Such a lovely day for riding a bike.");
		} else {
			System.out.println("You can't ride a bike that has one or more flat tires!");
		}
	}

	/**
	 * Increases the number of flat tires by one.
	 * Before increasing the number of flats, this method checks to ensure
	 * an additional flat fire will not exceed the total number of tires on the bicycle
	 */
	public void flat() {
		if (numberOfFlats + 1 <= numberOfTires) {
			numberOfFlats++;
		} else {
			System.out.println("You can't have more flats than tires!");
		}
	}
}