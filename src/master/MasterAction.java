package master;

import java.awt.AWTException;
import java.awt.Robot;

import program.Closer;
import program.Program;

public class MasterAction {
	public static void main(String[] args) throws AWTException {

		Robot r = new Robot();
		Controller c  = new Controller();
		c.setRunning(true);
		new Closer(c,60).start();
		
		Program p = Program.premadeClicker(1, 20);
		System.out.println(p);
		System.out.println(p.isRunning());
		p.run(r, c);	
	}
}
