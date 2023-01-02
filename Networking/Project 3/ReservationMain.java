import java.net.MalformedURLException;
import java.rmi.*;

public interface ReservationMain extends Remote
{
	
	void registerSeat(String seat, String customer) throws RemoteException;
	boolean seatState(String seat) throws RemoteException;
	String getServerNum() throws RemoteException;
	String getOpenServer() throws RemoteException;
}
