import java.net.MalformedURLException;
import java.rmi.*;
import java.rmi.server.*;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class P2PClientImpl extends UnicastRemoteObject implements P2PClient
{
	public P2PClientImpl() throws RemoteException
	{
	}


	public void printMessage(String s) throws RemoteException
	{
		System.out.println(s);
	}
	
	public boolean vote() throws RemoteException
	{
		Random random = new Random();
		return random.nextBoolean();
	}
	
	
	public boolean test() throws RemoteException
	{
		return true;
	}
}
