import java.io.*;
import java.net.*;

public class MidTermClient
{
	public static void main(String[] args) throws IOException
	{

		if (args.length < 3)
		{
			System.err.println("Usage: java MidTermClient <host name> <port number> <userType> <#ifUploadUser>");
			System.exit(1);
		}

		String hostName = args[0];
		int portNumber = Integer.parseInt(args[1]);

		try (Socket echoSocket = new Socket(hostName, portNumber);
				PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true);
				BufferedReader in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
				BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in)))
		{
			if (args[2].equalsIgnoreCase("U"))
			{
				try
				{
					Integer.valueOf(args[3]);
				} catch (Exception e)
				{
					System.err
							.println("Usage: java MidTermClient <host name> <port number> <userType> <#ifUploadUser>");
					System.exit(1);
				}
				out.println("U" + args[3]);
				echoSocket.close();
			}
			if (args[2].equalsIgnoreCase("R"))
			{
				out.println("R");
				System.out.println(in.readLine());
				echoSocket.close();
			}
			echoSocket.close();
		} catch (UnknownHostException e)
		{
			System.err.println("Don't know about host " + hostName);
			System.exit(1);
		} catch (IOException e)
		{
			System.err.println("Couldn't get I/O for the connection to " + hostName);
			System.exit(1);
		}
	}
}
