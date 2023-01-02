import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class SeatServerSecondary
{
	public static void main(String[] args) throws Exception
	{
		Registry r = LocateRegistry.getRegistry();
		ReservationServer server = new ReservationServerImpl();
		ReservationMain Mainserver = (ReservationMain) r.lookup("reservationservice");
		
		String serverName = "reservation" + Mainserver.getServerNum();
		r.rebind(serverName, server);
	}
}
