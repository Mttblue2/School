public class Marge implements Runnable { 
    String name;
    CookyJar jar; 

    public Marge(CookyJar jar, String name) { 
        this.jar = jar; 
	this.name = name;
    } 

    public void bake(int cookyNumber) { 
        jar.putCooky(name, cookyNumber); 
        try { 
            Thread.sleep((int)Math.random() * 500); 
        } catch (InterruptedException ie) {} 
    } 

    public void run() { 
        for (int i = 0 ; i < 10 ; i++) bake(i); 
    } 
} 
