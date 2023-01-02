public class Homer implements Runnable { 
    CookyJar jar; 

    public Homer(CookyJar jar) { 
        this.jar = jar; 
    } 

    public void eat() { 
        jar.getCooky("Homer"); 
        try { 
             Thread.sleep((int)Math.random() * 1000); 
        } catch (InterruptedException ie) {} 
    } 

    public void run() { 
        for (int i = 1 ; i <= 10 ; i++) eat(); 
    } 
} 
