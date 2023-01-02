import java.rmi.* ;
import java.rmi.server.* ;
  public class MessageWriterImpl extends UnicastRemoteObject
                                                              implements MessageWriter {
       public MessageWriterImpl() throws RemoteException {
       }
       public void writeMessage(String s) throws RemoteException {
              System.out.println(s) ;
       }
  }
