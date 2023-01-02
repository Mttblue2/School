public class Homer implements Runnable { 
    CookyJar jar; 
    String name;

    public Homer(CookyJar jar, String name) { 
        this.jar = jar; 
	this.name = name;
    } 

    public void eat() { 
        jar.getCooky(name); 
        try { 
             Thread.sleep((int)Math.random() * 1000); 
        } catch (InterruptedException ie) {} 
    } 

    public void run() { 
        for (int i = 1 ; i <= 10 ; i++) eat(); 
    } 
} 
