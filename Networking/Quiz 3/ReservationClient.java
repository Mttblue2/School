import java.net.MalformedURLException;
import java.rmi.*;

public interface ReservationClient extends Remote
{
	void printMessage(String s) throws RemoteException;
}
