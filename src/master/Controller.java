package master;

public class Controller {
	
	private boolean running;
	
	public synchronized void setRunning(boolean state) {
		running = state;
	}
	
	
	public synchronized boolean isRunning() {
		return running;
	}
}
