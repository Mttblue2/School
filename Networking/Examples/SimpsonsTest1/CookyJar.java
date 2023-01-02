public class CookyJar { 
    private int contents; 
    private boolean available = false; 

    public synchronized void getCooky(String who) { 
        while (!available) { 
            try { 
                wait(); 
            } catch (InterruptedException e) { } 
        } 
        available = false; 
        notifyAll(); 
        System.out.println( who + " ate cooky " + contents); 
     } 
    public synchronized void putCooky(String who, int value) { 
        while (available) { 
            try { 
                wait(); 
            } catch (InterruptedException e) { } 
        } 
        contents = value; 
        available = true; 
        System.out.println(who + " put cooky " + contents + 
                                      " in the jar"); 
        notifyAll(); 
    } } 

