package program.action;

import java.awt.Robot;

import master.Controller;

public abstract class Action {
	public abstract void perform(Robot r,Controller c);

	protected abstract String getString(String tabs);

	public final String toString() {
		return getString("");
	}
}
