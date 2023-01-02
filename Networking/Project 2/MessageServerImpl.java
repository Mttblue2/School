import java.net.MalformedURLException;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.*;
import java.util.Arrays;

public class MessageServerImpl extends UnicastRemoteObject implements MessageServer
{
	public MessageServerImpl() throws RemoteException
	{
	}

	public void enterChat(String ip, String name)
	{
		MessageClient client;

		try
		{
			Registry r = LocateRegistry.getRegistry(ip);
			String[] names = r.list();

			for (int x = 0; x < names.length; x++)
			{
				if (!names[x].equals("messageservice"))
				{
					client = (MessageClient) r.lookup(names[x]);
					client.printMessage("Welcome " + name + "!");
				}
			}

		} catch (RemoteException | NotBoundException e)
		{
			System.out.println(e);
		}
	}

	public void writeMessage(String s, String ip, String name) throws RemoteException
	{
		MessageClient client;

		try
		{
			Registry r = LocateRegistry.getRegistry(ip);
			String[] names = r.list();
			System.out.println(Arrays.toString(names));

			for (int x = 0; x < names.length; x++)
			{
				if (!names[x].equals("messageservice"))
				{
					client = (MessageClient) r.lookup(names[x]);
					client.printMessage(names[x] + ": " + s);
				}
			}

		} catch (RemoteException | NotBoundException e)
		{
			System.out.println(e);
		}
	}
}
