import java.net.MalformedURLException;
import java.rmi.*;

public interface MessageClient extends Remote
{
	void printMessage(String s) throws RemoteException;
}
