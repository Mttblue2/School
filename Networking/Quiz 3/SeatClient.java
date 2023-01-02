import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Arrays;
import java.util.Scanner;

public class SeatClient
{
	public static void main(String[] args) throws Exception
	{
		
		if (args.length != 2)
		{
			System.out.println("Usage: java ChatClient <host ip> <client name>");
			System.exit(0);
		}
		
		Registry r = LocateRegistry.getRegistry(args[0]);
		ReservationClient Client = new ReservationClientImpl();
		r.rebind(args[1], Client);
		
		try
		{
			ReservationServer Server = (ReservationServer) r.lookup("reservationservice");
			
			Scanner keyboard = new Scanner(System.in);
			String customer, seat, content;
			
			System.out.println("These are the avaible seats.");
			Server.printSeats(args[0], args[1]);
			System.out.println("Type Quit to exit. Else, press enter.");

			while (!(content = keyboard.nextLine()).equalsIgnoreCase("Quit"))
			{
				System.out.println("Please enter a seat number.");
				seat = keyboard.nextLine();
				
				try
				{
					int x = Integer.parseInt(seat);
					
					if (x < 1 || x > 25)
						throw new ArrayIndexOutOfBoundsException();
					
					System.out.println("Please enter a customer name.");
					customer = keyboard.nextLine();
					
					Server.registerSeat(seat, customer, args[0], args[1]);
					
					System.out.println("");
					System.out.println("These are the avaible seats.");
					Server.printSeats(args[0], args[1]);
					
				} catch (Exception e)
				{
					System.out.println("Error: must be a number between 1-25");
				}
				
				System.out.println("Type Quit to exit. Else, press enter.");
			}
			
			keyboard.close();
			r.unbind(args[1]);
			System.exit(0);
		} catch (Exception e)
		{
			System.out.print(e);
			System.exit(0);
		}

	}
}
