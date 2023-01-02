import java.net.MalformedURLException;
import java.rmi.*;
import java.rmi.server.*;
import java.util.Arrays;
import java.util.Scanner;

public class ReservationClientImpl extends UnicastRemoteObject implements ReservationClient
{
	public ReservationClientImpl() throws RemoteException
	{
	}


	public void printMessage(String s) throws RemoteException
	{
		System.out.println(s);
	}
}
