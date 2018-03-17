package shakti.winter.expression;

import java.util.List;

public abstract class Operator<Arg, Res> {

	String symbol;
	protected List<Arg> argLzt;
	boolean loaded = false;
	public int nargs;
	
	public Operator(String symbol, int nargs) {
		this.symbol = symbol;
		this.nargs = nargs;
	}
	
	public void load(List<Arg> argLzt) {
		this.argLzt = argLzt;
		loaded = true;
	}
	
	public abstract Res go();
	
	public abstract String display();
}
