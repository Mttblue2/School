import java.io.File;
import java.util.Scanner;

public class HashDriver
{
	public static void main(String[] args)
	{
		String inFilename = "in1.in";
		Hashtable t = new Hashtable(10);

		Scanner inputStream = null;

		try
		{
			inputStream = new Scanner(new File(inFilename));

			while (inputStream.hasNextLine())
			{
				String line = inputStream.nextLine();
				String name = line.substring(0, line.indexOf(";"));
				String number = line.substring(line.indexOf(";") + 1, line.length());
				t.put(name, number.trim());
			}
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		finally
		{
			inputStream.close();
		}

		System.out.println(t);
	}

}
