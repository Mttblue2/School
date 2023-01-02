
public class HashEntry
{
	String name, number;

	public HashEntry(String name, String number)
	{
		this.name = name;
		this.number = number;
	}

	@Override
	public String toString()
	{
		return name + " =>" + number;
	}

}
