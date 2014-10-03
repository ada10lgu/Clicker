package program.action;

import java.awt.Robot;

import master.Controller;

public class Block extends Action {

	private Action[] actions;

	public Block(Action... actions) {
		this.actions = actions;
	}

	@Override
	public void perform(Robot r, Controller c) {
		for (Action a : actions) {
			if (!c.isRunning())
				return;
			a.perform(r, c);
		}
	}

	@Override
	public String getString(String tabs) {
		StringBuilder sb = new StringBuilder();
		for (Action a : actions)
			sb.append(tabs).append(a.getString(tabs)).append("\n");
		return sb.toString();
	}

}
