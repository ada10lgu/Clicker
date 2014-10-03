package program.action;

import java.awt.Robot;
import java.awt.event.InputEvent;

import master.Controller;

public class KeyClick extends Action {

	@Override
	public void perform(Robot r,Controller c) {
		r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	}

	@Override
	public String getString(String tabs) {
		return "Klick";
	}

}
