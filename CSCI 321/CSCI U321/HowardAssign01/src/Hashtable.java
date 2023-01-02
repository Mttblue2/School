
public class Hashtable
{
	HashEntry[] hashtable;
	int table_size;

	public Hashtable(int size)
	{
		table_size = size;
		hashtable = new HashEntry[size];
	}

	public void put(String name, String number)
	{
		int hash = (int) name.charAt(0);
		hash = (hash * 17) % (table_size);
		int probe = 0, t_probe = 0;

		int loc = hash;

		if (this.hashtable[loc] == null)
			this.hashtable[loc] = new HashEntry(name, number);
		else
		{
			loc++;
			probe++;
			loc = loc % table_size;

			while (hashtable[loc] != null)
			{
				int temp = (int) hashtable[loc].name.charAt(0);
				temp = (temp * 17) % (table_size);

				while (temp != loc)
				{
					t_probe++;
					temp++;
					temp = temp % table_size;
				}

				if (probe <= t_probe)
				{
					t_probe = 0;
					loc++;
					probe++;
					loc = loc % table_size;
				}
				else
				{

					String t_name = hashtable[loc].name;
					String t_number = hashtable[loc].number;

					hashtable[loc].name = name;
					hashtable[loc].number = number;
					put(t_name, t_number);
					break;
				}
			}

			if (hashtable[loc] == null)
				hashtable[loc] = new HashEntry(name, number);
		}
	}

	public String get(String name)
	{
		boolean found = false;

		int hash = (int) name.charAt(0);
		hash = (hash * 17) % (table_size);

		try
		{
			while (found != true)
			{
				hash = hash % table_size;

				if (hashtable[hash].name.equals(name))
				{
					found = true;
					return hashtable[hash].number;
				}
				hash++;

			}
		}

		catch (Exception NullPointerException)
		{
		}
		return "Not Found";

	}

	public void printHashElementInfo(String key)
	{
		int hash = (key.charAt(0) * 17) % (table_size);
		boolean found = false;
		int probe = 0, s_index, i_index = hash;
		String value;

		while (found != true)
		{
			if (hashtable[hash].name.equals(key))
			{
				found = true;
			}
			else
			{
				probe++;
				hash++;
				hash = hash % table_size;
			}
		}
		value = hashtable[hash].number;
		s_index = hash;

		System.out.println(key + " =>" + value);
		System.out.println("Stored Index: " + s_index + ", Ideal index: " + i_index + ", Probe length: " + probe);
	}

	public String toString()
	{
		String s = "";
		int probe = 0;
		for (int x = 0; x < table_size; x++)
		{
			if (!(hashtable[x] == null))
			{
				probe = 0;
				int loc = (int) hashtable[x].name.charAt(0);
				loc = (loc * 17) % (table_size);

				while (loc != x)
				{
					probe++;
					loc++;
					loc = loc % table_size;
				}
			}

			if (hashtable[x] == null)
				s = s + "[" + x + "]:  " + "\n";
			else if (x == (table_size - 1))
				s = s + "[" + x + "]:  " + hashtable[x] + " [Probe Length: " + probe + "]";
			else
				s = s + "[" + x + "]:  " + hashtable[x] + " [Probe Length: " + probe + "]" + "\n";
		}
		return s;
	}

}
