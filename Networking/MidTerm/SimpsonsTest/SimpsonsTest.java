public class SimpsonsTest { 

    public static void main(String[] args) { 

        CookyJar jar = new CookyJar(3); 

        Homer homer = new Homer(jar); 
        Marge marge = new Marge(jar); 

        new Thread(homer).start(); 
        new Thread(marge).start(); 
    } 
} 
