import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class QuestionServer
{
	public static void main(String[] args) throws Exception
	{
		Registry r = LocateRegistry.getRegistry();
		P2PServer server = new P2PServerImpl();
		r.rebind("p2pservice", server);
	}
}
