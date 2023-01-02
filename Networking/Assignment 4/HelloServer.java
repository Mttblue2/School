import java.rmi.* ;
public class HelloServer
{
       public static void main(String [] args) throws Exception
	   {
              MessageWriter server = new MessageWriterImpl() ;
              Naming.rebind("messageservice", server) ;
       }
}
