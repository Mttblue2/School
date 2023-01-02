import java.net.MalformedURLException;
import java.rmi.*;

public interface P2PClient extends Remote
{
	void printMessage(String s) throws RemoteException;
	boolean vote() throws RemoteException;
	boolean test() throws RemoteException;
}
