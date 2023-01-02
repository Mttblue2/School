import java.net.MalformedURLException;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.*;
import java.util.Arrays;

public class ReservationServerImpl extends UnicastRemoteObject implements ReservationServer
{
	public ReservationServerImpl() throws RemoteException
	{
	}
	
	public void printSeats(String ip, String name) throws RemoteException
	{
		try
		{
			Registry r = LocateRegistry.getRegistry(ip);
			ReservationClient client = (ReservationClient) r.lookup(name);
			ReservationMain Server = (ReservationMain) r.lookup("reservationservice");
			
			String availableSeats = "";
			
			for (int x = 2; x < 52; x++)
			{
				if (Server.seatState(Integer.toString(x-1)) == true)
					availableSeats = availableSeats + (x-1) + " ";
			}
			 client.printMessage(availableSeats);
			
		} catch (RemoteException | NotBoundException e)
		{
			System.out.println(e);
		}
	}
	
	public synchronized void registerSeat(String seat, String customer, String ip, String name) throws RemoteException
	{
		
		try
		{
			Registry r = LocateRegistry.getRegistry(ip);
			ReservationClient client = (ReservationClient) r.lookup(name);
			ReservationMain Server = (ReservationMain) r.lookup("reservationservice");
			
			if (Server.seatState(seat) == true)
			{
				Server.registerSeat(seat, customer);
				client.printMessage("Customer registered in seat " + seat + ".");
			}
			else
				client.printMessage("Seat already taken");
			
		} catch (RemoteException | NotBoundException e)
		{
			System.out.println(e);
		}
	}
	
	public boolean test() throws RemoteException
	{
		return true;
	}

}
