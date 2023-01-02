import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class SeatServerMain
{
	public static void main(String[] args) throws Exception
	{
		Registry r = LocateRegistry.getRegistry();
		ReservationMain server = new ReservationMainImpl();
		r.rebind("reservationservice", server);
	}
}
