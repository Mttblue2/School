
public interface Database
{
	// Find out how many items are in the database
	public int size();

	// Display the items in the database on the screen
	public void display();

	// Find a particular item in the database
	public Pet find(String petName);

	/*
	 * Add an item to the database, if there is room return true if added, false
	 * otherwise
	 */
	public boolean add(Pet p);

	/*
	 * Delete an item from the database, if it is there return true if deleted,
	 * false otherwise
	 */
	public boolean delete(Pet p);
}
