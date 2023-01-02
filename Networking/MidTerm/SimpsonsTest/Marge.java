public class Marge implements Runnable { 
    CookyJar jar; 

    public Marge(CookyJar jar) { 
        this.jar = jar; 
    } 

    public void bake(int cookyNumber) { 
        jar.putCooky("Marge", cookyNumber); 
        try { 
            Thread.sleep((int)Math.random() * 500); 
        } catch (InterruptedException ie) {} 
    } 

    public void run() { 
        for (int i = 0 ; i < 10 ; i++) bake(i); 
    } 
} 
