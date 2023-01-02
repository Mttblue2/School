class Job implements Runnable {
	private static Thread [] jobs = new Thread[4];
	private int threadID;
	public Job(int ID) {
		threadID = ID;
	}
	public void run() { System.out.println("Hello "+ threadID +"!"); }
	public static void main(String [] args) {
		for(int i=0; i<jobs.length; i++) {
		    jobs[i] = new Thread(new Job(i));
		    jobs[i].start();
		}
		try {
		    for(int i=0; i<jobs.length; i++) {
		        jobs[i].join();
		    }
		} catch(InterruptedException e) { System.out.println(e); }
		System.out.println("Done!");
	}
}
