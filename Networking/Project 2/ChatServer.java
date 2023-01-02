import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ChatServer
{
	public static void main(String[] args) throws Exception
	{
		Registry r = LocateRegistry.getRegistry();
		MessageServer server = new MessageServerImpl();
		r.rebind("messageservice", server);
	}
}
