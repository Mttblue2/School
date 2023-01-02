
public class Pet
{
	private String pet_name, owner_name;
	private int visits;
	protected double cost, weight;

	public Pet(String pet_name, String owner_name, double weight)
	{
		super();
		this.pet_name = pet_name;
		this.owner_name = owner_name;
		this.weight = weight;
	}

	public void visit(int shots)
	{
		visits++;
		cost = cost + 85 + 30 * shots;
	}

	public String getPet_name()
	{
		return pet_name;
	}

	public String getOwner_name()
	{
		return owner_name;
	}

	public int getVisits()
	{
		return visits;
	}

	public double getCost()
	{
		return cost;
	}

	public double getWeight()
	{
		return weight;
	}

	@Override
	public String toString()
	{
		if (visits == 0)
			return pet_name + " : " + owner_name + " : " + weight + " : " + visits + " visit(s)";
		else
			return pet_name + " : " + owner_name + " : " + weight + " : " + visits + " visit(s), "
					+ "Average Cost / visit: " + cost / visits;
	}

}
