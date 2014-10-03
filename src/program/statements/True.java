package program.statements;

public class True extends Statement {

	@Override
	public boolean evaluate() {
		return true;
	}
	
	@Override
	public String getString(String tabs) {
		return "true";
	}
}
