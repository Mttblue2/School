import java.rmi.* ;
    public interface  MessageWriter  extends Remote
	{
           int factorial (int n)  throws RemoteException ;
    }
