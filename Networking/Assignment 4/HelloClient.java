import java.rmi.* ;
public class HelloClient {
       public static void main(String [] args) throws Exception
	   {
              MessageWriter server =(MessageWriter) Naming.lookup("rmi://127.0.0.1/messageservice") ;
			//MessageWriter server =(MessageWriter) Naming.lookup("rmi://fedora1.uscupstate.edu/messageservice") ;

			try
			{
              System.out.println(server.factorial(Integer.parseInt(args[0])));
			}
			catch (Exception e)
			{
				System.out.println("Command must be: java HelloClient [number]");
			}
       }
}
