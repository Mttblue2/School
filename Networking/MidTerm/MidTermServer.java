import java.net.*;
import java.io.*;

public class MidTermServer
{
	static int count = 0;
	
	public static void main(String[] args) throws IOException
	{

		if (args.length != 1)
		{
			System.err.println("Usage: java EchoServer <port number>");
			System.exit(1);
		}

		int portNumber = Integer.parseInt(args[0]);

		try
		{
			ServerSocket serverSocket = new ServerSocket(Integer.parseInt(args[0]));
			while (true)
			{
				Socket clientSocket = serverSocket.accept();
				Thread handle = new Thread(new ClientHandler(clientSocket));
				handle.start();
			}
		} catch (IOException e)
		{
			System.out.println(
					"Exception caught when trying to listen on port " + portNumber + " or listening for a connection");
			System.out.println(e.getMessage());
		}
	}

	private static class ClientHandler implements Runnable
	{
		// The connection with the client
		private Socket connection;

		public ClientHandler(Socket s)
		{
			connection = s;
		}

		public void run()
		{

			try
			{
				PrintWriter out = new PrintWriter(connection.getOutputStream(), true);
				BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				String inputLine, number = "";
				
				while ((inputLine = in.readLine()) != null)
				{
					if (inputLine.charAt(0) == 'U')
					{
						for (int x = 1; x < inputLine.length(); x++)
							number = number + inputLine.charAt(x);
						
						count = count + Integer.valueOf(number);
					}
					if (inputLine.charAt(0) == 'R')
					{
						out.println(count);
					}
				}
				
			} catch (IOException e)
			{
				System.out.println("Exception caught when trying to listen on the port or listening for a connection");
				System.out.println(e.getMessage());
			}

		}

	}
}
