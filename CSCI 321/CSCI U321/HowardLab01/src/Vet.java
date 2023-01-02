
public class Vet implements Database
{
	private Pet[] list;
	private String clinic;
	private int size, pet_counter, marker;

	public Vet(String clinic, int t_size)
	{
		this.clinic = clinic;
		pet_counter = 0;
		size = t_size;
		list = new Pet[t_size];
	}

	@Override
	public int size()
	{
		return pet_counter;
	}

	@Override
	public void display()
	{
		int temp = 0;

		System.out.println(clinic + " Pet List");

		while (temp < pet_counter)
		{
			System.out.println(list[temp].toString());
			temp++;
		}

	}

	@Override
	public Pet find(String petName)
	{
		marker = 1;

		if (pet_counter == 0)
		{
			return null;
		}
		while (marker <= pet_counter)
		{
			if (list[marker - 1].getPet_name().equals(petName))
			{
				return list[marker - 1];
			}
			marker++;
		}
		return null;
	}

	@Override
	public boolean add(Pet p)
	{
		if (pet_counter < size)
		{
			list[pet_counter] = p;
			pet_counter++;
			return true;
		}
		else
			return false;
	}

	@Override
	public boolean delete(Pet p)
	{
		if (find(p.getPet_name()) == null)
			return false;
		else
		{
			while (marker < size && list[marker] != null)
			{
				list[marker - 1] = list[marker];
				marker++;
			}
			pet_counter--;
			return true;
		}

	}

}
