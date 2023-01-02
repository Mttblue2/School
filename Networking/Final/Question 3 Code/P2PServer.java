import java.net.MalformedURLException;
import java.rmi.*;

public interface P2PServer extends Remote
{
	String[] getList(String s, String ip) throws RemoteException;
}
