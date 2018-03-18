package shakti.winter.expression;

import shakti.winter.tools.*;

public abstract class BinaryOperator<Arg, Res> extends Operator<Arg, Res>{
	
	public BinaryOperator(String symbol) {
		super(symbol, 2);
	}

	@Override
	public Res go() {
		return act(argLzt.get(0), argLzt.get(1));
	}
	
	public abstract Res act(Arg a, Arg b);
	
	public void load(Arg a, Arg b) {
		load(Tools.listIt(a, b));
	}
	
	@Override
	public String display() {
		return "("+argLzt.get(0)+" "+symbol+" "+argLzt.get(1)+")";
	}
}
