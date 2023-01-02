public class SimpsonsTest { 

    public static void main(String[] args) { 

        CookyJar jar = new CookyJar(); 
        //CookyJar jar2 = new CookyJar(); 

        Homer homer = new Homer(jar,"Homer0"); 
        Marge marge = new Marge(jar,"Marge0"); 
        //Homer homer1 = new Homer(jar,"Homer1"); 
	//Marge marge1 = new Marge(jar,"Marge1");
 	//Homer homer2 = new Homer(jar2,"Homer2");
	//Marge marge2 = new Marge(jar2,"Marge2"); 

        new Thread(homer).start(); 
        new Thread(marge).start(); 
	//new Thread(homer1).start(); 
        //new Thread(marge1).start(); 
	//new Thread(homer2).start();
	//new Thread(marge2).start(); 
    } 
} 
