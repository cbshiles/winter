package shakti.winter.operator.manifest;

import shakti.winter.operator.UnaryOperator;

public class Abs extends UnaryOperator<Integer, Integer>{

	public Abs() {
		super("", Integer.class, Integer.class);
	}

	@Override
	public Integer act(Integer n) {
		return n<0?-n:n;
	}
	
	@Override
	public String display() {
		return " |"+argLzt.get(0)+"| ";
	}
}
