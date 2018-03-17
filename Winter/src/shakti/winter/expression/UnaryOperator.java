package shakti.winter.expression;

import java.util.List;

import shakti.winter.Tools;

public abstract class UnaryOperator<Arg, Res> extends Operator<Arg, Res>{

	public UnaryOperator(String symbol) {
		super(symbol, 1);
	}

	@Override
	public Res go() {
		return act(argLzt.get(0));
	}
	
	public abstract Res act(Arg arg);
	
	public void load(Arg arg) {
		load(Tools.listIt(arg));
	}
	
	@Override
	public String display() {
		return "("+symbol+" "+argLzt.get(0)+")";
	}

}
