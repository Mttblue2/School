import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.time.LocalTime;

public class Driver
{
	public static void main(String[] args)
	{
		String inFilename = "in2.in";
		ArrayList<Event> eList = new ArrayList<Event>();

		Scanner inputStream = null;

		try
		{
			inputStream = new Scanner(new File(inFilename));

			while (inputStream.hasNextLine())
			{
				String line = inputStream.nextLine();
				String name = line.substring(0, line.indexOf(";"));
				LocalTime deadline = LocalTime.parse(line.substring(line.indexOf(";") + 2, line.lastIndexOf(";")));
				int duration = Integer.parseInt(line.substring(line.lastIndexOf(";") + 2, line.length()));
				
				eList.add(new Event(name, deadline, duration));
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
		
		/*Scheduler s = new Scheduler();
		s.schedule(eList);
		s.execute(LocalTime.parse("09:00:00"), LocalTime.parse("12:00:00"));*/
		
		/*Scheduler s = new Scheduler();
		s.schedule(eList);
		s.execute(LocalTime.parse("09:30:00"),LocalTime.parse("14:00:00"));*/
		
		Scheduler s = new Scheduler();
		s.schedule(eList);
		s.execute(LocalTime.parse("06:30:00"),LocalTime.parse("20:00:00"));
	}
}
