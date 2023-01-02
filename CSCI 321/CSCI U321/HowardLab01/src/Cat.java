
public class Cat extends Pet
{
	private boolean is_outside;

	public Cat(String pet_name, String owner_name, int weight, boolean is_outside)
	{
		super(pet_name, owner_name, weight);
		this.is_outside = is_outside;
	}

	public void visit(int shots)
	{
		super.visit(shots);
		cost = cost + 20;
		if (is_outside == true)
			cost = cost + 30;
	}

	public boolean Is_outside()
	{
		return is_outside;
	}

	public void setIs_outside(boolean is_outside)
	{
		this.is_outside = is_outside;
	}

	@Override
	public String toString()
	{

		if (is_outside == true)
			return super.toString() + " [Outside Cat]";
		else
			return super.toString() + " [Inside Cat]";
	}

}