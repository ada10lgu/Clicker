package program.action;

import java.awt.Robot;

import master.Controller;
import program.statements.Statement;

public class WhileLoop extends Action {

	private Action a;
	private Statement s;

	public WhileLoop(Statement s, Action a) {
		this.a = a;
		this.s = s;
	}

	@Override
	public void perform(Robot r,Controller c) {
		while (s.evaluate() && c.isRunning())
				a.perform(r,c);
	}

	@Override
	public String getString(String tabs) {
		StringBuilder sb = new StringBuilder();
		sb.append("while(").append(s.getString(tabs)).append(")\n");
		sb.append(a.getString(tabs + "\t"));
		return sb.toString();
	}

}
