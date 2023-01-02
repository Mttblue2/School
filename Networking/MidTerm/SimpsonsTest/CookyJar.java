public class CookyJar
{
	private int contents, limit, count = 0;
	private boolean available = false;
	
	public CookyJar (int max)
	{
		limit = max;
	}

	public synchronized void getCooky(String who)
	{
		while (!available)
		{
			try
			{
				wait();
			} catch (InterruptedException e)
			{
			}
		}
		available = false;
		notifyAll();
		System.out.println(who + " ate cooky " + contents);
	}

	public synchronized void putCooky(String who, int value)
	{
		while (available)
		{
			try
			{
				wait();
			} catch (InterruptedException e)
			{
			}
		}
		contents = value;
		System.out.println(who + " put cooky " + contents + " in the jar");
		count++;
		if (count == limit)
		{
			available = true;
			notify();
		}
	}
}
