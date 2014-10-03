package program;

import master.Controller;

public class Closer extends Thread {
	private int ttl;
	private Controller c;
	
	
	public Closer(Controller c, int ttl) {
		this.ttl = ttl;
		this.c = c;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(1000 * ttl);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		c.setRunning(false);
		System.out.println("Closer done!");
	}
}
