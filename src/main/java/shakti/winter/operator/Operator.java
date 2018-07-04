package shakti.winter.operator;

import java.util.List;

public abstract class Operator<ARG, RET> {

	public String symbol;
	protected List<ARG> argLzt;
	public int nargs;
	public Class<ARG> argClass;
	public Class<RET> retClass;
	
	public Operator(String symbol, int nargs, Class<ARG> argClass, Class<RET> retClass) {
		this.symbol = symbol;
		this.nargs = nargs;
		this.argClass = argClass;
		this.retClass = retClass;
	}
	
	public void load(List<ARG> argLzt) {
		this.argLzt = argLzt;
	}
	
	public abstract RET go();
	
	public abstract String display();
}
