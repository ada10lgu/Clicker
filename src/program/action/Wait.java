package program.action;

import java.awt.Robot;

import master.Controller;

public class Wait extends Action {

	private int time;
	
	public Wait(int time) {
		this.time =time;
	}
	
	@Override
	public void perform(Robot r,Controller c) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getString(String tabs) {
		return "wait(" + time + ")";
	}

}
