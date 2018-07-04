package shakti.winter.operator;

import java.util.List;

import shakti.winter.tools.*;

public abstract class UnaryOperator<ARG, RET> extends Operator<ARG, RET>{

	public UnaryOperator(String symbol, Class<ARG> argClass, Class<RET> retClass) {
		super(symbol, 1, argClass, retClass);
	}

	@Override
	public RET go() {
		return act(argLzt.get(0));
	}
	
	public abstract RET act(ARG arg);
	
	public void load(ARG arg) {
		load(Tools.listIt(arg));
	}
	
	@Override
	public String display() {
		return "("+symbol+" "+argLzt.get(0)+")";
	}

}
