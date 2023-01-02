import java.rmi.* ;
import java.rmi.server.* ;
  public class MessageWriterImpl extends UnicastRemoteObject implements MessageWriter
  {
       public MessageWriterImpl() throws RemoteException
	   {
		   
       }
       public int factorial (int n) throws RemoteException
	   {
			int total = 1;
			
              for (int x = 1; x <=n; x++)
				  total = total *x;
			  return total;
       }
  }
