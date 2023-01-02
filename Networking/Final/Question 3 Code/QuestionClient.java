import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class QuestionClient
{
	public static void main(String[] args) throws Exception
	{

		if (args.length != 2)
		{
			System.out.println("Usage: java ChatClient <host ip> <client name>");
			System.exit(0);
		}

		Registry r = LocateRegistry.getRegistry(args[0]);
		P2PClient Client = new P2PClientImpl();
		r.rebind(args[1], Client);

		try
		{
			P2PServer Server = (P2PServer) r.lookup("p2pservice");

			Scanner keyboard = new Scanner(System.in);
			String content;

			String[] list = Server.getList(args[0], args[1]);
			list = select(list);

			while (!(content = keyboard.nextLine()).equalsIgnoreCase("Quit"))
			{
				System.out.println("Please enter your question if you have one.");
				content = keyboard.nextLine();
				//this if statement checks to see if additional clients have come only if their are <5 neighbors assigned
				if (list.length < 5)
				{
					list = Server.getList(args[0], args[1]);
					list = select(list);
				}
				//this while statement makes sure all neighbors are active/online, and replaces the ones that aren't
				while (!verifyList(list))
				{
					list = Server.getList(args[0], args[1]);
					list = select(list);
				}

				int v = vote(list);
				System.out.println(v);

				if (v > (list.length - v))
					System.out.println("Majority Voted Yes");
				else if (v == (list.length - v))
					System.out.println("Majority Voted Tie");
				else
					System.out.println("Majority Voted No");

				System.out.println("Type Quit to exit");
			}

			keyboard.close();
			r.unbind(args[1]);
		} catch (Exception e)
		{
			System.out.print(e);
			System.exit(0);
		}

	}

	private static String[] select(String[] list)
	{
		if (list.length <= 5)
			return list;

		int[] selected = new int[list.length];
		Arrays.fill(selected, 0);

		String[] newList = new String[5];
		int y = 0;
		Random random = new Random();

		while (y < 5)
		{
			int x = random.nextInt(list.length);

			if (selected[x] == 0)
			{
				selected[x] = 1;
				newList[y] = list[x];
				y++;
			}
		}

		return newList;
	}

	private static boolean verifyList(String[] list) throws RemoteException
	{
		Registry r = LocateRegistry.getRegistry();
		for (int x = 0; x < list.length; x++)
		{
			try
			{
				P2PClient QC = (P2PClient) r.lookup(list[x]);
				QC.test();
			} catch (Exception e)
			{
				try
				{
					r.unbind(list[x]);
				} catch (RemoteException | NotBoundException e1)
				{
				}
				return false;
			}
		}
		return true;
	}

	private static int vote(String[] list)
	{
		int v = 0;
		for (int x = 0; x < list.length; x++)
		{
			try
			{
				Registry r = LocateRegistry.getRegistry();
				P2PClient QC = (P2PClient) r.lookup(list[x]);
				if (QC.vote())
					v++;
			} catch (Exception e)
			{
				return 0;
			}
		}
		return v;
	}
}
