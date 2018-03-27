package shakti.winter.operator;

import shakti.winter.tools.*;

public abstract class BinaryOperator<ARG, RET> extends Operator<ARG, RET>{
	
	public BinaryOperator(String symbol, Class<ARG> argClass, Class<RET> retClass) {
		super(symbol, 2, argClass, retClass);
	}

	@Override
	public RET go() {
		return act(argLzt.get(0), argLzt.get(1));
	}
	
	public abstract RET act(ARG a, ARG b);
	
	public void load(ARG a, ARG b) {
		load(Tools.listIt(a, b));
	}
	
	@Override
	public String display() {
		return "("+argLzt.get(0)+" "+symbol+" "+argLzt.get(1)+")";
	}
}
