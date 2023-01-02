import java.net.MalformedURLException;
import java.rmi.*;

public interface ReservationServer extends Remote
{
	
	void printSeats(String ip, String name) throws RemoteException;
	void registerSeat(String seat, String customer, String ip, String name) throws RemoteException;
	
}
