
public class Dog extends Pet
{
	private String size;

	public Dog(String pet_name, String owner_name, int weight, String size)
	{
		super(pet_name, owner_name, weight);
		this.size = size;
	}

	public void visit(int shots)
	{
		super.visit(shots);
		cost = cost + 15;

		if (size.equals("medium"))
			cost = cost + 2.5 * shots;
		else if (size.equals("large"))
			cost = cost + 5 * shots;
	}

	public String getSize()
	{
		return size;
	}

	public void setSize(String size)
	{
		this.size = size;
	}

	@Override
	public String toString()
	{
		super.toString();

		if (size.equals("small"))
			return super.toString() + " [small Dog]";
		else if (size.equals("medium"))
			return super.toString() + " [medium Dog]";
		else
			return super.toString() + " [large Dog]";
	}

}
