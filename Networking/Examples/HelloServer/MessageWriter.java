import java.rmi.* ;
    public interface  MessageWriter  extends Remote {
           void  writeMessage(String s)  throws RemoteException ;
    }
