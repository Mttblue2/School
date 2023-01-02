import java.net.MalformedURLException;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.*;
import java.util.Arrays;

public class ReservationServerImpl extends UnicastRemoteObject implements ReservationServer
{
	String[] seats;
	
	public ReservationServerImpl() throws RemoteException
	{
		seats = new String[25];
		Arrays.fill(seats, "");
	}
	
	public void printSeats(String ip, String name)
	{
		try
		{
			Registry r = LocateRegistry.getRegistry(ip);
			ReservationClient client = (ReservationClient) r.lookup(name);
			
			String availableSeats = "";
			
			for (int x = 0; x < 25; x++)
			{
				if (seats[x].equals(""))
					availableSeats = availableSeats + (x + 1) + " ";
			}
			 client.printMessage(availableSeats);
			
		} catch (RemoteException | NotBoundException e)
		{
			System.out.println(e);
		}
	}
	
	public void registerSeat(String seat, String customer, String ip, String name)
	{
		
		try
		{
			Registry r = LocateRegistry.getRegistry(ip);
			ReservationClient client = (ReservationClient) r.lookup(name);
			
			if (seats[Integer.parseInt(seat)-1].equals(""))
			{
				seats[Integer.parseInt(seat)-1] = customer;
				client.printMessage("Customer registered in seat " + seat + ".");
			}
			else
				client.printMessage("Seat already taken");
			
		} catch (RemoteException | NotBoundException e)
		{
			System.out.println(e);
		}
	}
	
	public

}
