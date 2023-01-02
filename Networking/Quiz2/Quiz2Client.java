import java.io.*;
import java.net.*;

public class Quiz2Client
{
	public static void main(String[] args) throws IOException
	{

		if (args.length != 2)
		{
			System.err.println("Usage: java EchoClient <host name> <port number>");
			System.exit(1);
		}

		String hostName = args[0];
		int portNumber = Integer.parseInt(args[1]);

		try (Socket echoSocket = new Socket(hostName, portNumber);
				PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true);
				BufferedReader in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
				BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in)))
		{
			System.out.println(in.readLine());

			String userInput;
			while (!(userInput = stdIn.readLine()).equals("Quit."))
			{
				out.println(userInput);
				System.out.println("You have submitted " + in.readLine() + " lines so far");
				System.out.println("Your last line reversed is " + in.readLine());
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
