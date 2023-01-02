import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class SeatServer
{
	public static void main(String[] args) throws Exception
	{
		Registry r = LocateRegistry.getRegistry();
		ReservationServer server = new ReservationServerImpl();
		r.rebind("reservationservice", server);
	}
}
