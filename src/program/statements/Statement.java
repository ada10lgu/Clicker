package program.statements;

public abstract class Statement {
	public abstract boolean evaluate();
	
	public abstract String getString(String tabs);
	
	public final String toString() {
		return getString("");
	}
}
