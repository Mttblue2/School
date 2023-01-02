import java.time.LocalTime;
import java.util.ArrayList;

public class Scheduler
{
	MinHeap<Event> MH;

	public void schedule(ArrayList<Event> events)
	{
		MH = new MinHeap<Event>();

		for (int x = 0; x <= events.size() - 1; x++)
		{
			MH.add(events.get(x));
		}
	}

	public void execute(LocalTime start, LocalTime end)
	{
		String finished = "", unfinished = "";

		if (MH.isEmpty() == true)
			System.out.println("MinHead is Empty");

		else
		{
			
			while (MH.isEmpty() != true)
			{
				Event temp = MH.remove();

				if (start.plusMinutes(temp.duration).isBefore(temp.deadline) 
					&& start.plusMinutes(temp.duration).isAfter(end) == false
					|| start.plusMinutes(temp.duration).equals(temp.deadline) )
				{
					finished = finished + start.toString() + ": " + temp.name + "[ending at "
							+ start.plusMinutes(temp.duration).toString() + " with a deadline of "
							+ temp.deadline.toString() + "]" + "\n";

					start = start.plusMinutes(temp.duration);
				}
				else if (start.plusMinutes(temp.duration).isAfter(temp.deadline)
						&& start.plusMinutes(temp.duration).isBefore(end))
				{
					finished = finished + "Note: the event named " + temp.name + " will not be completed until "
								     + start.plusMinutes(temp.duration) + " but has a deadline of "
								     + temp.deadline.toString() + ". The event will be skipped." + "\n";
				}
				else if (start.plusMinutes(temp.duration).isAfter(end) == true)
				{
					if (unfinished.equals(""))
					{
						unfinished = "**Not enough time to complete all tasks. Tasks left unfinished:**" + "\n"
								+ "Event [name=" + temp.name + ", deadline=" + temp.deadline.toString() + ", duration="
								+ temp.duration + "]" + "\n";
					}
					else
					{
						unfinished = unfinished + "Event [name=" + temp.name + ", deadline=" + temp.deadline.toString()
								+ ", duration=" + temp.duration + "]" + "\n";
					}
				}
			}
			System.out.print(finished);
			System.out.println();
			System.out.print(unfinished);
		}
	}

}
