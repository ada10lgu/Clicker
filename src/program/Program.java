package program;

import java.awt.Robot;

import master.Controller;
import program.action.Action;
import program.action.Block;
import program.action.KeyClick;
import program.action.Wait;
import program.action.WhileLoop;
import program.statements.Statement;
import program.statements.True;

public class Program {

	private Action action;
	private boolean running;

	public Program(Action action) {
		this.action = action;
	}

	public synchronized void run(Robot r, Controller c) {
		while (running)
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		setRunning(true);
		new ProgramThread(r, c).start();
	}

	public synchronized boolean isRunning() {
		return running;
	}

	private synchronized void setRunning(boolean state) {
		running = state;
		notifyAll();
	}
	

	private class ProgramThread extends Thread {

		private Controller c;
		private Robot r;

		public ProgramThread(Robot r, Controller c) {
			this.c = c;
			this.r = r;
		}

		@Override
		public void run() {
			action.perform(r, c);
			setRunning(false);
		}
	}

	public static Program premadeClicker(int startDelay, int loopWait) {
		Action a = new Block(new KeyClick(), new Wait(loopWait));
		Statement s = new True();
		Action a2 = new WhileLoop(s, a);
		Action a3 = new Block(new Wait(startDelay * 1000), a2);

		return new Program(a3);
	}
	
	@Override
	public String toString() {
		return action.toString();
		
	}

}
