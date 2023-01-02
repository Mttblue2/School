import java.net.MalformedURLException;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.*;
import java.util.Arrays;

public class P2PServerImpl extends UnicastRemoteObject implements P2PServer
{
	public P2PServerImpl() throws RemoteException
	{
	}

	public String[] getList(String ip, String name)
	{
		try
		{
			Registry r = LocateRegistry.getRegistry(ip);
			String[] names = r.list();
			String[] list = new String[names.length-2];
			int y = 0;
			
			for (int x = 0; x < names.length; x++)
			{
				if (!names[x].equals("p2pservice") && !names[x].equals(name))
				{
					list[y] = names[x];
					y++;
				}

			}
			
			return list;

		} catch (RemoteException e)
		{
			System.out.println(e);
			return null;
		}
	}
}
