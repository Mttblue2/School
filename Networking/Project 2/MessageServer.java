import java.net.MalformedURLException;
import java.rmi.*;

public interface MessageServer extends Remote
{
	void writeMessage(String s, String ip, String name) throws RemoteException;
	void enterChat(String s, String ip) throws RemoteException;
}
