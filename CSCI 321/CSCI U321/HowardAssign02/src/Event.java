import java.time.LocalTime;

public class Event implements Comparable<Event>
{
	public String name;
	public LocalTime deadline;
	public int duration;

	public Event(String name, LocalTime deadline, int duration)
	{
		this.name = name;
		this.deadline = deadline;
		this.duration = duration;
	}

	public int compareTo(Event event)
	{
		if (this.deadline.equals(event.deadline))
		{
			if (this.duration > event.duration)
				return 1;
			else
				return -1;
		}
		else
			return this.deadline.compareTo(event.deadline);
	}
}
