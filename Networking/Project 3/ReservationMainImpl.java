import java.net.MalformedURLException;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.*;
import java.util.Arrays;
import java.util.Random;

public class ReservationMainImpl extends UnicastRemoteObject implements ReservationMain
{
	String[] seats;
	String[] servers;

	public ReservationMainImpl() throws RemoteException
	{
		seats = new String[50];
		servers = new String[50];
		Arrays.fill(seats, "");
		Arrays.fill(servers, "");
	}

	public synchronized void registerSeat(String seat, String customer) throws RemoteException
	{

		seats[Integer.parseInt(seat) - 1] = customer;

	}

	public boolean seatState(String seat) throws RemoteException
	{
		if (seats[Integer.parseInt(seat) - 1].contentEquals(""))
			return true;
		else
			return false;
	}

	public String getServerNum() throws RemoteException
	{
		for (int x = 0; x < servers.length; x++)
		{
			if (servers[x].equals(""))
			{
				servers[x] = "taken";

				return Integer.toString(x);
			}
		}

		return "-1";
	}

	public String getOpenServer() throws RemoteException
	{
		Random random = new Random();
		String[] temp = new String[100];
		int count = 0;

		for (int x = 0; x < servers.length; x++)
		{
			if (!servers[x].equals(""))
			{
				temp[count] = Integer.toString(x);
				count++;
			}

		}
		
		int num = random.nextInt(count);
		
		return "reservation" + temp[num];
		
		
	}

}
