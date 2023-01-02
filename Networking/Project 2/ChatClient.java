import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Arrays;
import java.util.Scanner;

public class ChatClient
{
	public static void main(String[] args) throws Exception
	{
		
		if (args.length != 2)
		{
			System.out.println("Usage: java ChatClient <host ip> <client name>");
			System.exit(0);
		}
		
		Registry r = LocateRegistry.getRegistry(args[0]);
		MessageClient Client = new MessageClientImpl();
		r.rebind(args[1], Client);
		
		try
		{
			MessageServer Server = (MessageServer) r.lookup("messageservice");
			
			Scanner keyboard = new Scanner(System.in);
			String content;
			
			Server.enterChat(args[0], args[1]);

			while (!(content = keyboard.nextLine()).equalsIgnoreCase("Quit"))
			{
				Server.writeMessage(content, args[0], args[1]);
			}
			
			keyboard.close();
			r.unbind(args[1]);
		} catch (Exception e)
		{
			System.out.print(e);
			System.exit(0);
		}
		
	}
}
